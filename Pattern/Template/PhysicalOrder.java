public class PhysicalOrder extends OrderProcess{

    private final String name;

    PhysicalOrder( String name ) {
        this.name = name;
    }   

    @Override
    public void deliverItem() {
        System.out.println("you item " + this.name + "has been delivered");
    }
}
