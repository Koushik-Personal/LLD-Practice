
public class WhatsAppNotification implements Notification {

    public WhatsAppNotification() {
    }
    @Override
    public void send(String title, String message) {
        System.out.println("WhatsApp Notification: " + title + " - " + message);
    }
}
