import {
  Controller,
  Post,
  Headers,
  RawBodyRequest,
  Req,
  Logger,
  HttpStatus,
  Res,
} from '@nestjs/common';
import { Response } from 'express';
import { ConfigService } from '@nestjs/config';
import { StripeService } from './stripe.service';
import { PrismaService } from '../prisma/prisma.service';

@Controller('stripe/webhook')
export class StripeWebhookController {
  private readonly logger = new Logger(StripeWebhookController.name);

  constructor(
    private readonly stripeService: StripeService,
    private readonly prisma: PrismaService,
    private readonly configService: ConfigService,
  ) {}

  @Post()
  async handleWebhook(
    @Headers('stripe-signature') signature: string,
    @Req() request: RawBodyRequest<Request>,
    @Res() response: Response,
  ) {
    const payload = request.rawBody;
    const webhookSecret = this.configService.get<string>(
      'STRIPE_WEBHOOK_SECRET',
    );

    if (!webhookSecret) {
      this.logger.error('STRIPE_WEBHOOK_SECRET is not configured');
      return response
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .send('Webhook secret not configured');
    }

    try {
      const event = await this.stripeService.constructWebhookEvent(
        payload,
        signature,
        webhookSecret,
      );
      await this.handleStripeEvent(event);

      return response
        .status(HttpStatus.OK)
        .send('Webhook processed successfully');
    } catch (error) {
      this.logger.error(
        `Webhook signature verification failed: ${error.message}`,
      );
      return response
        .status(HttpStatus.BAD_REQUEST)
        .send('Webhook signature verification failed');
    }
  }

  private async handleStripeEvent(event: any) {
    this.logger.log(`Processing webhook event: ${event.type}`);

    switch (event.type) {
      case 'customer.subscription.created':
        await this.handleSubscriptionCreated(event.data.object);
        break;
      case 'customer.subscription.updated':
        await this.handleSubscriptionUpdated(event.data.object);
        break;
      case 'customer.subscription.deleted':
        await this.handleSubscriptionDeleted(event.data.object);
        break;
      case 'invoice.payment_succeeded':
        await this.handleInvoicePaymentSucceeded(event.data.object);
        break;
      case 'invoice.payment_failed':
        await this.handleInvoicePaymentFailed(event.data.object);
        break;
      case 'payment_method.attached':
        await this.handlePaymentMethodAttached(event.data.object);
        break;
      case 'payment_method.detached':
        await this.handlePaymentMethodDetached(event.data.object);
        break;
      default:
        this.logger.log(`Unhandled event type: ${event.type}`);
    }
  }

  private async handleSubscriptionCreated(subscription: any) {
    try {
      this.logger.log(`Subscription created: ${subscription.id}`);

      // The subscription is already saved in the StripeService.createSubscription method
      // This is just for logging and any additional processing
    } catch (error) {
      this.logger.error(
        `Error handling subscription created: ${error.message}`,
      );
    }
  }

  private async handleSubscriptionUpdated(subscription: any) {
    try {
      this.logger.log(`Subscription updated: ${subscription.id}`);

      // Update subscription in database
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
        `Error handling subscription updated: ${error.message}`,
      );
    }
  }

  private async handleSubscriptionDeleted(subscription: any) {
    try {
      this.logger.log(`Subscription deleted: ${subscription.id}`);

      // Update subscription status to canceled
      await this.prisma.subscription.update({
        where: { stripe_subscription_id: subscription.id },
        data: {
          status: 'CANCELED',
          canceled_at: new Date(),
        },
      });
    } catch (error) {
      this.logger.error(
        `Error handling subscription deleted: ${error.message}`,
      );
    }
  }

  private async handleInvoicePaymentSucceeded(invoice: any) {
    try {
      this.logger.log(`Invoice payment succeeded: ${invoice.id}`);

      // Save invoice to database
      await this.prisma.invoice.upsert({
        where: { stripe_invoice_id: invoice.id },
        update: {
          status: invoice.status,
          paid: invoice.paid,
          paid_at: invoice.paid ? new Date() : null,
        },
        create: {
          user_id: await this.getUserIdFromCustomerId(invoice.customer),
          stripe_invoice_id: invoice.id,
          subscription_id: invoice.subscription,
          amount: invoice.amount_paid,
          currency: invoice.currency,
          status: invoice.status,
          paid: invoice.paid,
          due_date: invoice.due_date ? new Date(invoice.due_date * 1000) : null,
          paid_at: invoice.paid ? new Date() : null,
        },
      });
    } catch (error) {
      this.logger.error(
        `Error handling invoice payment succeeded: ${error.message}`,
      );
    }
  }

  private async handleInvoicePaymentFailed(invoice: any) {
    try {
      this.logger.log(`Invoice payment failed: ${invoice.id}`);

      // Update invoice status
      await this.prisma.invoice.upsert({
        where: { stripe_invoice_id: invoice.id },
        update: {
          status: invoice.status,
          paid: false,
        },
        create: {
          user_id: await this.getUserIdFromCustomerId(invoice.customer),
          stripe_invoice_id: invoice.id,
          subscription_id: invoice.subscription,
          amount: invoice.amount_due,
          currency: invoice.currency,
          status: invoice.status,
          paid: false,
          due_date: invoice.due_date ? new Date(invoice.due_date * 1000) : null,
        },
      });
    } catch (error) {
      this.logger.error(
        `Error handling invoice payment failed: ${error.message}`,
      );
    }
  }

  private async handlePaymentMethodAttached(paymentMethod: any) {
    try {
      this.logger.log(`Payment method attached: ${paymentMethod.id}`);

      // Payment method is already saved in the SubscriptionService.addPaymentMethod method
      // This is just for logging and any additional processing
    } catch (error) {
      this.logger.error(
        `Error handling payment method attached: ${error.message}`,
      );
    }
  }

  private async handlePaymentMethodDetached(paymentMethod: any) {
    try {
      this.logger.log(`Payment method detached: ${paymentMethod.id}`);

      // Remove payment method from database
      await this.prisma.paymentMethod.deleteMany({
        where: { stripe_payment_method_id: paymentMethod.id },
      });
    } catch (error) {
      this.logger.error(
        `Error handling payment method detached: ${error.message}`,
      );
    }
  }

  private async getUserIdFromCustomerId(customerId: string): Promise<string> {
    const user = await this.prisma.user.findFirst({
      where: { stripe_customer_id: customerId },
    });

    if (!user) {
      throw new Error(`User not found for customer ID: ${customerId}`);
    }

    return user.user_id;
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