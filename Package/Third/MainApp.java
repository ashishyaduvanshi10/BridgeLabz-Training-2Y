import college.student.*;
import college.faculty.*;

public class MainApp {
    public static void main(String[] args) {
        Student s = new Student("Rahul", 101);
        Faculty f = new Faculty("Dr. Meena", "Math");
        s.display();
        f.display();
    }
}
