public class NotificationService {
    public static void main(String[] args) {

        Notification notification;

        notification = NotificationFactory.createNotification("email");
        notification.send("Welcome", "Email sent successfully");

        notification = NotificationFactory.createNotification("sms");
        notification.send("OTP", "Your OTP is 1234");

        notification = NotificationFactory.createNotification("push");
        notification.send("Update", "App update available");

        // Example of dynamic registration (new type added without modifying factory)
        NotificationFactory.register("whatsapp", WhatsAppNotification::new);

        notification = NotificationFactory.createNotification("whatsapp");
        notification.send("Hello", "WhatsApp message sent");    

    }
}