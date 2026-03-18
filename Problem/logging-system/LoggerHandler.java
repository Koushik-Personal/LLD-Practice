public abstract class LoggerHandler {
    
    protected LoggerHandler next;


    public void setNext( LoggerHandler logger) {
        this.next = logger;
    }

    public abstract void log(LogLevel level, String message);    
}
