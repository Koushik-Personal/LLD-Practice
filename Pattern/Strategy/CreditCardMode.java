public class CreditCardMode implements Payment {

    CreditCardMode() {}

    @Override
    public void send() {
        System.out.println("payment from credit card mode");
    }
    
}