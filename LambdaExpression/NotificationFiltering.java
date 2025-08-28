import java.util.*;
import java.util.function.*;

class Alert {
    String type;
    Alert(String type) { this.type = type; }
    public String toString() { return type; }
}

class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical"),
            new Alert("Normal"),
            new Alert("Emergency")
        );

        Predicate<Alert> criticalFilter = a -> a.type.equals("Critical");
        alerts.stream().filter(criticalFilter).forEach(System.out::println);
    }
}
