public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        NotificationChannel smsChannel = factory.getNotificationChannel(NotificationMedium.SMS);
        smsChannel.sendNotification("This is an SMS notification.");

        NotificationChannel emailChannel = factory.getNotificationChannel(NotificationMedium.EMAIL);
        emailChannel.sendNotification("This is an email notification.");

        NotificationChannel pushChannel = factory.getNotificationChannel(NotificationMedium.PUSH);
        pushChannel.sendNotification("This is a push notification.");   
    }
}
