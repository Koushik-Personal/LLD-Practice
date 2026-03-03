
public class SMSNotification implements Notification {

    public SMSNotification() {
    }

    @Override
    public void send(String title, String message) {
        System.out.println("SMS Notification: " + title + " - " + message);
    }

}
