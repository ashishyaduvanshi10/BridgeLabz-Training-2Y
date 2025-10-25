interface IRideService {
    void bookRide(String pickup, String drop, double distance);
    void endRide();
}

abstract class Vehicle implements IRideService {
    protected String vehicleNumber;
    protected int capacity;
    protected String type;
    private double fare;
    private String currentLocation;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.fare = 0.0;
        this.currentLocation = "Unknown";
    }

    public double getFare() {
        return fare;
    }

    protected void setFare(double fare) {
        this.fare = fare;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    public abstract void bookRide(String pickup, String drop, double distance);
    public abstract void endRide();
}

class Mini extends Vehicle {
    private double baseFare = 50;
    private double ratePerKm = 10;

    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        setFare(baseFare + distance * ratePerKm);
        setCurrentLocation(drop);
        System.out.println("Mini booked from " + pickup + " to " + drop + ". Fare: $" + getFare());
    }

    @Override
    public void endRide() {
        System.out.println("Mini ride ended at " + getCurrentLocation());
    }
}

class Sedan extends Vehicle {
    private double baseFare = 80;
    private double ratePerKm = 15;

    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        setFare(baseFare + distance * ratePerKm);
        setCurrentLocation(drop);
        System.out.println("Sedan booked from " + pickup + " to " + drop + ". Fare: $" + getFare());
    }

    @Override
    public void endRide() {
        System.out.println("Sedan ride ended at " + getCurrentLocation());
    }
}

class SUV extends Vehicle {
    private double baseFare = 100;
    private double ratePerKm = 20;

    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        setFare(baseFare + distance * ratePerKm);
        setCurrentLocation(drop);
        System.out.println("SUV booked from " + pickup + " to " + drop + ". Fare: $" + getFare());
    }

    @Override
    public void endRide() {
        System.out.println("SUV ride ended at " + getCurrentLocation());
    }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }

    public void displayDriverInfo() {
        System.out.println("Driver: " + name + ", License: " + licenseNumber + ", Rating: " + rating);
    }
}

public class CabbyGoDemo {
    public static void main(String[] args) {
        Driver d1 = new Driver("Alice", "LIC123", 4.8);
        Driver d2 = new Driver("Bob", "LIC456", 4.5);

        d1.displayDriverInfo();
        d2.displayDriverInfo();

        Vehicle v1 = new Mini("MINI001", 4);
        Vehicle v2 = new Sedan("SEDAN001", 4);
        Vehicle v3 = new SUV("SUV001", 6);

        v1.bookRide("Station", "Mall", 10);
        v2.bookRide("Airport", "Hotel", 15);
        v3.bookRide("Office", "Home", 20);

        v1.endRide();
        v2.endRide();
        v3.endRide();
    }
}
