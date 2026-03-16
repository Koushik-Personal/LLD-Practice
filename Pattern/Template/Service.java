public class Service {
    public static void main(String[] args) {
        

        OrderProcess process = new DigitalOrder("Ebook");

        process.processOrder();


        process = new PhysicalOrder("Iphone 12");

        process.processOrder();
    }
}