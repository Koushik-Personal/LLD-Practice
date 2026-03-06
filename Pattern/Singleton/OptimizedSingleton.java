public class OptimizedSingleton {
    

    private static volatile OptimizedSingleton instance;

    private OptimizedSingleton() {
    }

    public static OptimizedSingleton getInstance() {
        if (instance == null) {
            synchronized (OptimizedSingleton.class) {
                if (instance == null) {
                    instance = new OptimizedSingleton();
                }
            }
        }
        return instance;
    } 

}
