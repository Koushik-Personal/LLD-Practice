
class Service {

    public static void main(String[] args) {

        Handler logHandler = new LoggingHandler();
        Handler authHandler = new AuthenticationHandler();
        Handler authzHandler = new AuthorizationHandler();
        
        logHandler.setNext(authHandler);
        authHandler.setNext(authzHandler);

        logHandler.handle();
    }
    
}   