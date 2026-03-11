public class UpiMode implements Payment {

    UpiMode() {
    }

    @Override
    public void send() {
        System.out.println("payment from upi mode");
    }

    
}