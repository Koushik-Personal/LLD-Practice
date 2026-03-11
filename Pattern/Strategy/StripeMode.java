 public class StripeMode implements Payment{

     StripeMode() {}
    
    @Override
    public void send() {
        System.out.println("payment from stripe mode");
    }
    
}
