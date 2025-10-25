package college.faculty;
public class Faculty {
    String name, subject;
    public Faculty(String name, String subject) { this.name = name; this.subject = subject; }
    public void show() { System.out.println("Faculty: " + name + " teaches " + subject); }
}
