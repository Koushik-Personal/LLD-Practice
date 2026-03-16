public class AuthenticationHandler extends Handler{

    public AuthenticationHandler() {
    }

    @Override
    public void handle() {
        System.out.println("AuthenticationHandler");
        if (next != null)
            next.handle();
    }

    
    
}
