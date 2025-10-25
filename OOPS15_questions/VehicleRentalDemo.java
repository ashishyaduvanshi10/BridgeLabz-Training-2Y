interface Rentable {
    double calculateRent(int days);
}

abstract class Vehicle implements Rentable {
    protected String vehicleId;
    protected String brand;
    protected double baseRate;

    public Vehicle(String vehicleId, String brand, double baseRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public abstract void displayInfo();
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String brand, double baseRate) {
        super(vehicleId, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike: " + brand + " (" + vehicleId + ")");
    }
}

class Car extends Vehicle {
    private double insuranceFee;

    public Car(String vehicleId, String brand, double baseRate, double insuranceFee) {
        super(vehicleId, brand, baseRate);
        this.insuranceFee = insuranceFee;
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate * days) + insuranceFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " (" + vehicleId + ")");
    }
}

class Truck extends Vehicle {
    private double loadSurcharge;

    public Truck(String vehicleId, String brand, double baseRate, double loadSurcharge) {
        super(vehicleId, brand, baseRate);
        this.loadSurcharge = loadSurcharge;
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate * days) + loadSurcharge;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck: " + brand + " (" + vehicleId + ")");
    }
}

class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Customer: " + name + " (" + customerId + ")");
    }
}

public class VehicleRentalDemo {
    public static void main(String[] args) {
        Customer c1 = new Customer("C101", "John Doe");
        c1.displayInfo();

        Vehicle bike = new Bike("B001", "Yamaha", 15);
        Vehicle car = new Car("C001", "Toyota", 50, 20);
        Vehicle truck = new Truck("T001", "Volvo", 80, 40);

        bike.displayInfo();
        car.displayInfo();
        truck.displayInfo();

        System.out.println("Bike Rent (3 days): $" + bike.calculateRent(3));
        System.out.println("Car Rent (3 days): $" + car.calculateRent(3));
        System.out.println("Truck Rent (3 days): $" + truck.calculateRent(3));
    }
}
