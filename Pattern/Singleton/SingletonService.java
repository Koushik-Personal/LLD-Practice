public class SingletonService {
    
    EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
    EagerSingleton eagerSingleton = EagerSingleton.getInstance();
    NormalSingleton normalSingleton = NormalSingleton.getInstance();
    OptimizedSingleton optimizedSingleton = OptimizedSingleton.getInstance();
    SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
    BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();

}
