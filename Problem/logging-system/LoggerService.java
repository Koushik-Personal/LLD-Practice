public class LoggerService {
    public static void main(String[] args) {
        LoggerHandler consoleLogger = new ConsoleLogger();
        LoggerHandler fileLogger = new FileLogger();
        LoggerHandler databaseLogger = new DatabaseLogger();

        consoleLogger.setNext(fileLogger);
        fileLogger.setNext(databaseLogger);

        consoleLogger.log(LogLevel.DEBUG, "Debug message");
        consoleLogger.log(LogLevel.INFO, "Info message");
        consoleLogger.log(LogLevel.WARNING, "Warning message");
        consoleLogger.log(LogLevel.ERROR, "Error message");
        consoleLogger.log(LogLevel.FATAL, "Fatal message");

    }
}
