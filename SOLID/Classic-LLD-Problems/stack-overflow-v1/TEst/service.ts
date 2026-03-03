import { Injectable, Logger } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';
import Stripe from 'stripe';
import { PrismaService } from '../prisma/prisma.service';
import { getPlanByPriceId } from '../subscription/subscription.config';

@Injectable()
export class StripeService {
  private readonly stripe: Stripe;
  private readonly logger = new Logger(StripeService.name);

  constructor(
    private readonly configService: ConfigService,
    private readonly prisma: PrismaService,
  ) {
    this.stripe = new Stripe(
      this.configService.get<string>('STRIPE_SECRET_KEY'),
      {
        apiVersion: '2025-07-30.basil',
      },
    );
  }

  // Customer Management
  async createCustomer(
    userId: string,
    email: string,
    name?: string,
  ): Promise<string> {
    try {
      const customer = await this.stripe.customers.create({
        email,
        name,
        metadata: {
          userId,
        },
      });

      // Update user with Stripe customer ID
      await this.prisma.user.update({
        where: { user_id: userId },
        data: { stripe_customer_id: customer.id },
      });

      return customer.id;
    } catch (error) {
      this.logger.error(`Error creating Stripe customer: ${error.message}`);
      throw error;
    }
  }

  async getCustomer(customerId: string): Promise<Stripe.Customer> {
    try {
      return (await this.stripe.customers.retrieve(
        customerId,
      )) as Stripe.Customer;
    } catch (error) {
      this.logger.error(`Error retrieving Stripe customer: ${error.message}`);
      throw error;
    }
  }

  // Subscription Management
  async createSubscription(
    customerId: string,
    priceId: string,
    paymentMethodId?: string,
    trialDays?: number,
  ): Promise<Stripe.Subscription> {
    try {
      const subscriptionData: Stripe.SubscriptionCreateParams = {
        customer: customerId,
        items: [{ price: priceId }],
        payment_behavior: 'default_incomplete',
        expand: ['latest_invoice.payment_intent'],
      };

      if (trialDays) {
        subscriptionData.trial_period_days = trialDays;
      }

      if (paymentMethodId) {
        subscriptionData.default_payment_method = paymentMethodId;
      }

      const subscription =
        await this.stripe.subscriptions.create(subscriptionData);

      // Save subscription to database
      await this.saveSubscriptionToDatabase(subscription);

      return subscription;
    } catch (error) {
      this.logger.error(`Error creating subscription: ${error.message}`);
      throw error;
    }
  }

  async cancelSubscription(
    subscriptionId: string,
    cancelAtPeriodEnd: boolean = true,
  ): Promise<Stripe.Subscription> {
    try {
      let subscription: Stripe.Subscription;

      if (cancelAtPeriodEnd) {
        subscription = await this.stripe.subscriptions.update(subscriptionId, {
          cancel_at_period_end: true,
        });
      } else {
        subscription = await this.stripe.subscriptions.cancel(subscriptionId);
      }

      // Update subscription in database
      await this.updateSubscriptionInDatabase(subscription);

      return subscription;
    } catch (error) {
      this.logger.error(`Error canceling subscription: ${error.message}`);
      throw error;
    }
  }

  async reactivateSubscription(
    subscriptionId: string,
  ): Promise<Stripe.Subscription> {
    try {
      const subscription = await this.stripe.subscriptions.update(
        subscriptionId,
        {
          cancel_at_period_end: false,
        },
      );

      // Update subscription in database
      await this.updateSubscriptionInDatabase(subscription);

      return subscription;
    } catch (error) {
      this.logger.error(`Error reactivating subscription: ${error.message}`);
      throw error;
    }
  }

  async getSubscription(subscriptionId: string): Promise<Stripe.Subscription> {
    try {
      return await this.stripe.subscriptions.retrieve(subscriptionId);
    } catch (error) {
      this.logger.error(`Error retrieving subscription: ${error.message}`);
      throw error;
    }
  }

  // Payment Methods
  async createPaymentMethod(
    type: 'card',
    card: Stripe.PaymentMethodCreateParams.Card,
  ): Promise<Stripe.PaymentMethod> {
    try {
      return await this.stripe.paymentMethods.create({
        type,
        card,
      });
    } catch (error) {
      this.logger.error(`Error creating payment method: ${error.message}`);
      throw error;
    }
  }

  async attachPaymentMethodToCustomer(
    paymentMethodId: string,
    customerId: string,
  ): Promise<Stripe.PaymentMethod> {
    try {
      return await this.stripe.paymentMethods.attach(paymentMethodId, {
        customer: customerId,
      });
    } catch (error) {
      this.logger.error(`Error attaching payment method: ${error.message}`);
      throw error;
    }
  }

  async setDefaultPaymentMethod(
    customerId: string,
    paymentMethodId: string,
  ): Promise<Stripe.Customer> {
    try {
      return await this.stripe.customers.update(customerId, {
        invoice_settings: {
          default_payment_method: paymentMethodId,
        },
      });
    } catch (error) {
      this.logger.error(
        `Error setting default payment method: ${error.message}`,
      );
      throw error;
    }
  }

  async getCustomerPaymentMethods(
    customerId: string,
  ): Promise<Stripe.PaymentMethod[]> {
    try {
      const paymentMethods = await this.stripe.paymentMethods.list({
        customer: customerId,
        type: 'card',
      });
      return paymentMethods.data;
    } catch (error) {
      this.logger.error(`Error retrieving payment methods: ${error.message}`);
      throw error;
    }
  }

  // Products and Prices
  async getProducts(): Promise<Stripe.Product[]> {
    try {
      const products = await this.stripe.products.list({
        active: true,
        expand: ['data.default_price'],
      });
      return products.data;
    } catch (error) {
      this.logger.error(`Error retrieving products: ${error.message}`);
      throw error;
    }
  }

  async getPrices(): Promise<Stripe.Price[]> {
    try {
      const prices = await this.stripe.prices.list({
        active: true,
        expand: ['data.product'],
      });
      return prices.data;
    } catch (error) {
      this.logger.error(`Error retrieving prices: ${error.message}`);
      throw error;
    }
  }

  // Checkout Sessions
  async createCheckoutSession(
    customerEmail: string,
    priceId: string,
  ): Promise<{ url: string }> {
    try {
      const session = await this.stripe.checkout.sessions.create({
        customer_email: customerEmail,
        payment_method_types: ['card'],
        mode: 'subscription',
        line_items: [
          {
            price: priceId,
            quantity: 1,
          },
        ],
        success_url: `${this.configService.get('FRONTEND_URL')}?success=true`,
        cancel_url: `${this.configService.get('FRONTEND_URL')}?canceled=true`,
      });
      console.log(session?.url);
      return { url: session?.url };
    } catch (error) {
      this.logger.error(`Error creating checkout session: ${error.message}`);
      throw error;
    }
  }

  // Billing Portal
  async createBillingPortal(customerId: string): Promise<{ url: string }> {
    try {
      const session = await this.stripe.billingPortal.sessions.create({
        customer: customerId,
        return_url: this.configService.get('FRONTEND_URL'),
      });
      return { url: session.url };
    } catch (error) {
      this.logger.error(
        `Error creating billing portal session: ${error.message}`,
      );
      throw error;
    }
  }

  // Mobile Subscription Creation
  async createMobileSubscription(
    email: string,
    priceId: string,
  ): Promise<{
    customerId: string;
    ephemeralKey: string;
    clientSecret: string;
    subscriptionId: string;
  }> {
    try {
      // 1. Create or retrieve customer
      const customer = await this.stripe.customers.create({ email });
      console.log(customer, 'customer');
      // 2. Create subscription
      const subscription = await this.stripe.subscriptions.create({
        customer: customer.id,
        items: [{ price: priceId }],
        payment_behavior: 'default_incomplete',
        expand: ['latest_invoice'],
      });
      const intent = await this.stripe.paymentIntents.search({
        query: `customer:"${customer.id}",subscription:"${subscription.id}"`,
      });
      console.log(intent, 'intent');
      console.log(subscription, 'subscription');
      // 3. Create ephemeral key (temporary key for mobile)
      const ephemeralKey = await this.stripe.ephemeralKeys.create(
        { customer: customer.id },
        { apiVersion: '2024-06-20' },
      );
      console.log(ephemeralKey, 'ephemeralKey');

      // 4. Return info for Flutter
      const latestInvoice = subscription.latest_invoice as any;
      console.log(latestInvoice, 'latestInvoice');
      const paymentIntent =
        latestInvoice?.payment_intent as Stripe.PaymentIntent;

      console.log(paymentIntent, 'paymentIntent');
      if (!paymentIntent || !paymentIntent.client_secret) {
        throw new Error('Payment intent client secret not found');
      }

      return {
        customerId: customer.id,
        ephemeralKey: ephemeralKey.secret,
        clientSecret: paymentIntent.client_secret,
        subscriptionId: subscription.id,
      };
    } catch (error) {
      this.logger.error(`Error creating mobile subscription: ${error.message}`);
      throw error;
    }
  }

  // Webhook Processing
  async constructWebhookEvent(
    payload: string | Buffer,
    signature: string,
    secret: string,
  ): Promise<Stripe.Event> {
    try {
      return this.stripe.webhooks.constructEvent(payload, signature, secret);
    } catch (error) {
      this.logger.error(
        `Webhook signature verification failed: ${error.message}`,
      );
      throw error;
    }
  }

  // Database Operations
  private async saveSubscriptionToDatabase(
    subscription: Stripe.Subscription,
  ): Promise<void> {
    try {
      const user = await this.prisma.user.findFirst({
        where: { stripe_customer_id: subscription.customer as string },
      });

      if (!user) {
        throw new Error('User not found for customer ID');
      }

      // Determine plan type based on price ID or product
      const planType = getPlanByPriceId(subscription.items.data[0].price.id);

      await this.prisma.subscription.create({
        data: {
          user_id: user.user_id,
          stripe_subscription_id: subscription.id,
          stripe_price_id: subscription.items.data[0].price.id,
          plan_type: planType,
          status: this.mapStripeStatusToEnum(subscription.status),
          current_period_start: new Date(
            (subscription as any).current_period_start * 1000,
          ),
          current_period_end: new Date(
            (subscription as any).current_period_end * 1000,
          ),
          cancel_at_period_end: (subscription as any).cancel_at_period_end,
          canceled_at: (subscription as any).canceled_at
            ? new Date((subscription as any).canceled_at * 1000)
            : null,
          trial_start: (subscription as any).trial_start
            ? new Date((subscription as any).trial_start * 1000)
            : null,
          trial_end: (subscription as any).trial_end
            ? new Date((subscription as any).trial_end * 1000)
            : null,
        },
      });
    } catch (error) {
      this.logger.error(
        `Error saving subscription to database: ${error.message}`,
      );
      throw error;
    }
  }

  private async updateSubscriptionInDatabase(
    subscription: Stripe.Subscription,
  ): Promise<void> {
    try {
      await this.prisma.subscription.update({
        where: { stripe_subscription_id: subscription.id },
        data: {
          status: this.mapStripeStatusToEnum(subscription.status),
          current_period_start: new Date(
            (subscription as any).current_period_start * 1000,
          ),
          current_period_end: new Date(
            (subscription as any).current_period_end * 1000,
          ),
          cancel_at_period_end: (subscription as any).cancel_at_period_end,
          canceled_at: (subscription as any).canceled_at
            ? new Date((subscription as any).canceled_at * 1000)
            : null,
        },
      });
    } catch (error) {
      this.logger.error(
        `Error updating subscription in database: ${error.message}`,
      );
      throw error;
    }
  }

  private mapStripeStatusToEnum(
    status: string,
  ):
    | 'ACTIVE'
    | 'CANCELED'
    | 'PAST_DUE'
    | 'UNPAID'
    | 'TRIAL'
    | 'INCOMPLETE'
    | 'INCOMPLETE_EXPIRED' {
    switch (status) {
      case 'active':
        return 'ACTIVE';
      case 'canceled':
        return 'CANCELED';
      case 'past_due':
        return 'PAST_DUE';
      case 'unpaid':
        return 'UNPAID';
      case 'trialing':
        return 'TRIAL';
      case 'incomplete':
        return 'INCOMPLETE';
      case 'incomplete_expired':
        return 'INCOMPLETE_EXPIRED';
      default:
        return 'INCOMPLETE';
    }
  }
}