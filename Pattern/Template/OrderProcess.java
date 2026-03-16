abstract class OrderProcess {
    
    public void processOrder() {
        selectItem();
        makePayment();
        deliverItem();
    }

    public void selectItem() {
        System.out.println("Select Item");
    };
    public void makePayment() {
        System.out.println("Make Payment");
    };
    public void deliverItem() {
        System.out.println("Deliver Item");
    };

}
