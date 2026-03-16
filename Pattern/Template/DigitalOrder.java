public class DigitalOrder extends OrderProcess{

    private final String name;
    DigitalOrder(String name) {
        this.name = name;
    }

    @Override
    public void deliverItem() {
        System.out.println("you item " + this.name + "has been delivered");
    }
   
}