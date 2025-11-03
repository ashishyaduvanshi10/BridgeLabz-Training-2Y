import java.time.LocalDate;


class ServiceOverdueException extends Exception {
    public ServiceOverdueException(String message) {
        super(message);
    }
}


class InvalidMileageException extends Exception {
    public InvalidMileageException(String message) {
        super(message);
    }
}


class Vehicle {
    private String vehicleNumber;
    private LocalDate serviceDueDate;
    private int mileage;

    public Vehicle(String vehicleNumber, LocalDate serviceDueDate, int mileage) {
        this.vehicleNumber = vehicleNumber;
        this.serviceDueDate = serviceDueDate;
        this.mileage = mileage;
    }

    
    public void checkMaintenance() throws ServiceOverdueException, InvalidMileageException {
        LocalDate today = LocalDate.now();

        
        if (mileage < 0) {
            throw new InvalidMileageException(" Invalid mileage entered for vehicle " + vehicleNumber + "!");
        }

        
        if (serviceDueDate.isBefore(today)) {
            throw new ServiceOverdueException(" Service overdue for vehicle " + vehicleNumber + "! Due date was " + serviceDueDate);
        }

        
        System.out.println(" Vehicle " + vehicleNumber + " is in good condition. No maintenance needed right now.");
    }
}

public class VehicleMaintenanceTracker {
    public static void main(String[] args) {
        
        Vehicle car1 = new Vehicle("MH12AB1234", LocalDate.of(2024, 10, 15), 25000);
        Vehicle car2 = new Vehicle("MH12XY5678", LocalDate.of(2025, 12, 5), -100);

        System.out.println("=== Vehicle Maintenance Tracker ===");

        try {
            car1.checkMaintenance();
        } catch (ServiceOverdueException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMileageException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------");

        try {
            car2.checkMaintenance();
        } catch (ServiceOverdueException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMileageException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Maintenance check complete.");
    }
}
