
// this is a Bill Pugh Singleton
// this is thread safe
// this is lazy loaded
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
