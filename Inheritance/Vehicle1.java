interface Refuelable {
    void refuel();
}

class Vehicle1 {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity; // in kWh

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int tankCapacity; // in liters

    PetrolVehicle(String model, int maxSpeed, int tankCapacity) {
        super(model, maxSpeed);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Tank capacity: " + tankCapacity + " liters");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tank Capacity: " + tankCapacity + " liters");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        ev.displayInfo();
        ev.charge();

        System.out.println();

        pv.displayInfo();
        pv.refuel();
    }
}
