
// this is a eager singleton
// this is thread safe
// this is lazy loaded
// PROBLEM is it will create the instance as soon as the class is loaded
// Even it is not used
public class EagerSingleton {
    

    private final static EagerSingleton INSTANCE = new EagerSingleton();
    
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
