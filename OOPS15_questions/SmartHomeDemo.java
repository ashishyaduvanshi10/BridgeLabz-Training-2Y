interface Controllable {
    void turnOn();
    void turnOff();
}

abstract class Appliance implements Controllable {
    private String name;
    private boolean isOn;
    private double powerUsage;

    public Appliance(String name, double powerUsage) {
        this.name = name;
        this.powerUsage = powerUsage;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean state) {
        isOn = state;
    }

    public double getPowerUsage() {
        return powerUsage;
    }

    public void comparePower(Appliance other) {
        if (this.powerUsage > other.powerUsage) {
            System.out.println(this.name + " uses more power than " + other.getName());
        } else if (this.powerUsage < other.powerUsage) {
            System.out.println(this.name + " uses less power than " + other.getName());
        } else {
            System.out.println(this.name + " and " + other.getName() + " use equal power");
        }
    }

    public abstract void turnOn();
    public abstract void turnOff();
}

class Light extends Appliance {
    public Light(String name, double powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " light is ON");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " light is OFF");
    }
}

class Fan extends Appliance {
    public Fan(String name, double powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " fan is spinning");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " fan is stopped");
    }
}

class AC extends Appliance {
    public AC(String name, double powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " AC is cooling");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " AC is OFF");
    }
}

class UserController {
    public void controlDevice(Appliance device, boolean turnOn) {
        if (turnOn) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room", 10);
        Fan bedroomFan = new Fan("Bedroom", 50);
        AC ac = new AC("Living Room AC", 200);

        UserController controller = new UserController();

        controller.controlDevice(livingRoomLight, true);
        controller.controlDevice(bedroomFan, true);
        controller.controlDevice(ac, true);

        livingRoomLight.comparePower(bedroomFan);
        ac.comparePower(bedroomFan);

        controller.controlDevice(livingRoomLight, false);
        controller.controlDevice(ac, false);
    }
}
