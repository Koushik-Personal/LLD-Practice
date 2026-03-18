public class NotificationFactory {

    NotificationFactory() {}

    public NotificationChannel getNotificationChannel( NotificationMedium medium) {
    
        switch (medium) {
            case EMAIL:
                return new EmailChannel();
            case PUSH:
                return new PushChannel();
            case SMS:
                return new SMSChannel();
            default:
                throw new IllegalArgumentException("Invalid notification medium: " + medium);
        }
    }
    

}
