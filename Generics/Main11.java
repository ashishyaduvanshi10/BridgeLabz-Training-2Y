import java.util.*;

class Vehicle {
    String name;
    Vehicle(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Truck extends Vehicle {
    Truck(String name) {
        super(name);
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name);
    }
}

class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    public void showFleet() {
        for (T vehicle : fleet) {
            System.out.println(vehicle);
        }
    }
}

public class Main11 {
    public static void main(String[] args) {
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Truck 1"));
        truckFleet.addVehicle(new Truck("Truck 2"));

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Bike 1"));
        bikeFleet.addVehicle(new Bike("Bike 2"));

        truckFleet.showFleet();
        bikeFleet.showFleet();
    }
}
