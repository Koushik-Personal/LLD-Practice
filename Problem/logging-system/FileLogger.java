public class FileLogger  extends LoggerHandler{
    
    public FileLogger() {
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level == (LogLevel.WARNING)) {
            System.out.println("FileLogger" + level + ": " + message);
        } else if (level == (LogLevel.ERROR)) {
            System.out.println("FileLogger" + level + ": " + message);
            next.setNext(next);
        } else {
            if (next != null)
                next.log(level, message);
        }
    }
    
}
