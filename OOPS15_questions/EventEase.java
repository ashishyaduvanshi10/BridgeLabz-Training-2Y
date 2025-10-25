import java.util.*;

interface ISchedulable {
    void schedule();
    void reschedule(String newDate);
    void cancel();
}

class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}

abstract class Event implements ISchedulable {
    private final String eventId;
    private String eventName;
    private String location;
    private String date;
    private List<String> attendees;
    private double venueCost;
    private double serviceCost;
    private double discount;

    public Event(String eventName, String location, String date, List<String> attendees) {
        this.eventId = UUID.randomUUID().toString();
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setPricing(double venueCost, double serviceCost, double discount) {
        this.venueCost = venueCost;
        this.serviceCost = serviceCost;
        this.discount = discount;
    }

    public double calculateCost() {
        return venueCost + serviceCost - discount;
    }

    public abstract void schedule();

    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println("Event " + eventName + " rescheduled to " + newDate);
    }

    public void cancel() {
        System.out.println("Event " + eventName + " has been cancelled.");
    }
}

class BirthdayEvent extends Event {
    public BirthdayEvent(String name, String location, String date, List<String> attendees) {
        super(name, location, date, attendees);
    }
    public void schedule() {
        System.out.println("Birthday party scheduled at " + getLocation() + " on " + getDate());
    }
}

class ConferenceEvent extends Event {
    public ConferenceEvent(String name, String location, String date, List<String> attendees) {
        super(name, location, date, attendees);
    }
    public void schedule() {
        System.out.println("Conference scheduled at " + getLocation() + " on " + getDate());
    }
}

public class EventEase {
    public static void main(String[] args) {
        User organizer = new User("Alice", "alice@mail.com", "1234567890");

        List<String> guests = Arrays.asList("Bob", "Charlie", "Diana");
        Event birthday = new BirthdayEvent("Bob's Birthday", "City Hall", "2025-10-01", guests);
        birthday.setPricing(500, 200, 50);
        birthday.schedule();
        System.out.println("Cost: " + birthday.calculateCost());

        List<String> team = Arrays.asList("Tom", "Jerry", "Anna");
        Event conference = new ConferenceEvent("Tech Meet", "Grand Hotel", "2025-11-15", team);
        conference.setPricing(1000, 500, 100);
        conference.schedule();
        System.out.println("Cost: " + conference.calculateCost());

        conference.reschedule("2025-12-01");
        birthday.cancel();
    }
}
