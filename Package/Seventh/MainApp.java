import com.school.data.*;
import com.school.util.*;

public class MainApp {
    public static void main(String[] args) {
        Student s = new Student("Sneha", 80, 85, 90);
        Analyzer a = new Analyzer();
        double avg = a.calculateAverage(s);
        System.out.println(s);
        System.out.println("Average: " + avg + ", Grade: " + a.findGrade(avg));
    }
}
