class PaymentService {
    public static void main(String[] args) {
        
        PaymentProcessor payment = new PaymentProcessor(new CreditCardMode());
        payment.pay();

        payment.set(new PayPalMode());
        payment.pay();

        payment.set(new UpiMode());
        payment.pay();

        payment.set(new StripeMode());
        payment.pay();
    }
}