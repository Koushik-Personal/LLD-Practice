
// this is a synchronized singleton
// this is thread safe
// this is lazy loaded

// PROBLEM IS : this is very Slow under heavy concurrency
public class SynchronizedSingleton {
    
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
