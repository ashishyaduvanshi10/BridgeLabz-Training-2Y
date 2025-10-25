import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String toString() {
        return "[" + type.toUpperCase() + "] " + message;
    }
}

public class HospitalNotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("emergency", "Patient 101 needs immediate attention"),
            new Alert("medication", "Patient 102 requires 5mg insulin"),
            new Alert("appointment", "Patient 103 check-up at 4 PM"),
            new Alert("lab", "Patient 104 test results available"),
            new Alert("emergency", "Patient 105 critical condition")
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter preferred alert type (emergency/medication/appointment/lab): ");
        String preference = sc.nextLine();

        Predicate<Alert> filterByPreference = alert -> alert.type.equalsIgnoreCase(preference);

        List<Alert> filteredAlerts = alerts.stream()
                                           .filter(filterByPreference)
                                           .collect(Collectors.toList());

        System.out.println("\nFiltered Alerts (" + preference + "):");
        filteredAlerts.forEach(System.out::println);
    }
}
