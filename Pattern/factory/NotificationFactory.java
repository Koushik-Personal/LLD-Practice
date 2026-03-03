import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {


    private static final Map<String, Supplier<Notification>> registry = new HashMap<>();

    // Static block for registration
    static {
        registry.put("email", EmailNotification::new);
        registry.put("sms", SMSNotification::new);
        registry.put("push", PushNotification::new);
    }

    // Factory method
    public static Notification createNotification(String type) {

        Supplier<Notification> supplier = registry.get(type.toLowerCase());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid notification type: " + type);
        }

        return supplier.get();
    }

    public static void register(String type, Supplier<Notification> supplier) {
        registry.put(type.toLowerCase(), supplier);
    }
}
