
// this is a normal singleton
// this is not thread safe
// this is not lazy loaded
public class NormalSingleton {
    
    private static NormalSingleton instance;

    public static NormalSingleton getInstance() {
        if (instance == null) {
            instance = new NormalSingleton();
        }
        return instance;
    }

}
