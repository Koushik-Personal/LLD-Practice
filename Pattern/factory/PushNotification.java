
public class PushNotification implements Notification {

    public PushNotification() {

    }

    @Override
    public void send(String title, String message) {
        System.out.println("Push Notification: " + title + " - " + message);
    }
}
