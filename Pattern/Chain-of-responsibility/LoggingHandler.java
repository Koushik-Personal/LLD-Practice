 class LoggingHandler extends Handler {


    public LoggingHandler() {
    }

    @Override
    public void handle() {
        System.out.println("LoggingHandler");
        if ( next != null )
            next.handle();
    }

}
