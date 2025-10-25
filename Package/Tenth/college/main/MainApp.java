import college.student.*;
import college.faculty.*;
import college.department.*;

public class MainApp {
    public static void main(String[] args) {
        Student s = new Student("Riya", 10);
        Faculty f = new Faculty("Dr. Arjun", "Physics");
        Department d = new Department("Science");
        s.show();
        f.show();
        d.show();
    }
}
