public class SMSChannel implements NotificationChannel {
    
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
