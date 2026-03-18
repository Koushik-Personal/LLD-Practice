public class ConsoleLogger extends LoggerHandler {

    public ConsoleLogger() {
    }

    @Override
    public void log(LogLevel level, String message) {

        if (level == (LogLevel.DEBUG) || level == (LogLevel.INFO)) {
            System.out.println("ConsoleLogger" + level + ": " + message);
        } else {
            if (next != null)
                next.log(level, message);
        }
    }

}
