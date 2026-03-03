
/*
    * this class is responsible for
    * Managing the observer
 */    
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}