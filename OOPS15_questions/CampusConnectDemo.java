import java.util.ArrayList;
import java.util.List;

interface ICourseActions {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

abstract class Person {
    protected String id;
    protected String name;
    protected String email;

    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract void printDetails();
}

class Student extends Person implements ICourseActions {
    private List<Course> courses;
    private List<Double> grades;

    public Student(String id, String name, String email) {
        super(id, name, email);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    @Override
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        grades.add(0.0);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    @Override
    public void dropCourse(Course course) {
        int index = courses.indexOf(course);
        if (index >= 0) {
            courses.remove(index);
            grades.remove(index);
            course.removeStudent(this);
            System.out.println(name + " dropped " + course.getCourseName());
        }
    }

    public void assignGrade(Course course, double grade) {
        int index = courses.indexOf(course);
        if (index >= 0) {
            grades.set(index, grade);
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + name + ", Email: " + email + ", GPA: " + calculateGPA());
    }
}

class Faculty extends Person {
    private List<Course> teachingCourses;

    public Faculty(String id, String name, String email) {
        super(id, name, email);
        teachingCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        teachingCourses.add(course);
        course.setFaculty(this);
        System.out.println(name + " assigned to teach " + course.getCourseName());
    }

    @Override
    public void printDetails() {
        System.out.println("Faculty: " + name + ", Email: " + email + ", Courses: " + teachingCourses.size());
    }
}

class Course {
    private String courseId;
    private String courseName;
    private Faculty faculty;
    private List<Student> students;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}

public class CampusConnectDemo {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("F001", "Dr. Smith", "smith@college.edu");
        Faculty f2 = new Faculty("F002", "Prof. Johnson", "johnson@college.edu");

        Course c1 = new Course("C101", "Data Structures");
        Course c2 = new Course("C102", "Operating Systems");

        f1.assignCourse(c1);
        f2.assignCourse(c2);

        Student s1 = new Student("S001", "Alice", "alice@college.edu");
        Student s2 = new Student("S002", "Bob", "bob@college.edu");

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);

        s1.assignGrade(c1, 3.8);
        s1.assignGrade(c2, 3.6);
        s2.assignGrade(c1, 3.4);

        s1.printDetails();
        s2.printDetails();
        f1.printDetails();
        f2.printDetails();
    }
}
