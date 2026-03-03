
public class EmailNotification implements Notification {

    public EmailNotification() {
    }

    @Override
    public void send(String title, String message) {
        System.out.println("Email Notification: " + title + " - " + message);
    }
}
