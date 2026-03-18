public class DatabaseLogger extends LoggerHandler {


    public DatabaseLogger() {
    }

    @Override  
    public void log(LogLevel level, String message) {
        
        if (level == (LogLevel.ERROR) || level == (LogLevel.FATAL)) {
            System.out.println("DatabaseLogger" + level + ": " + message);
        } else {
            if (next != null)
                next.log(level, message);
        }
    }
}
