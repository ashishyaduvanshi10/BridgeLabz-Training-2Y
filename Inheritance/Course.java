class Course {
    String courseName;
    int duration; // in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        Course course = new Course("Basic Math", 20);
        course.displayDetails();

        System.out.println();

        OnlineCourse online = new OnlineCourse("Intro to Java", 30, "Udemy", true);
        online.displayDetails();

        System.out.println();

        PaidOnlineCourse paid = new PaidOnlineCourse("Advanced Python", 40, "Coursera", true, 199.99, 15);
        paid.displayDetails();
    }
}
