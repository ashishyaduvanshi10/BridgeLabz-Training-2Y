import java.util.*;

class Patient {
    String id;
    String name;

    Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
}

public class HospitalPatientIDPrinting {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("P001", "Alice"),
            new Patient("P002", "Bob"),
            new Patient("P003", "Charlie"),
            new Patient("P004", "Diana")
        );

        System.out.println("All Patient IDs:");
        patients.stream()
                .map(Patient::getId)
                .forEach(System.out::println);
    }
}
