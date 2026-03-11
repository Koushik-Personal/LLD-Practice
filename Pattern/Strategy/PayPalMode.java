public class PayPalMode  implements Payment{

    PayPalMode() {}

    
    @Override
    public void send() {
        System.out.println("payment from paypal mode");
    }
}