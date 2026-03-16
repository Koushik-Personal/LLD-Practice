public class AuthorizationHandler extends Handler {

    public AuthorizationHandler()  {
    }

    @Override
    public void handle() {
        System.out.println("AuthorizationHandler");
        if (next != null)
            next.handle();
    }
    
}
