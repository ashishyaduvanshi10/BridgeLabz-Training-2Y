interface Graded {
    void assignGrade(String grade);
}

abstract class Student {
    protected String studentId;
    protected String name;
    private double gpa;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = 0.0;
    }

    public Student(String studentId, String name, double gpa) {
        this(studentId, name);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    protected void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void displayTranscript() {
        System.out.println(name + "'s GPA: " + gpa);
    }

    public abstract void enrollCourse(Course course);
}

class Undergraduate extends Student {
    public Undergraduate(String studentId, String name) {
        super(studentId, name);
    }

    @Override
    public void enrollCourse(Course course) {
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }
}

class Postgraduate extends Student {
    public Postgraduate(String studentId, String name) {
        super(studentId, name);
    }

    @Override
    public void enrollCourse(Course course) {
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }
}

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        System.out.println("Student " + student.studentId + " added to " + courseName);
    }
}

class Faculty {
    private String facultyId;
    private String name;

    public Faculty(String facultyId, String name) {
        this.facultyId = facultyId;
        this.name = name;
    }

    public void assignGrade(Enrollment enrollment, String grade) {
        enrollment.assignGrade(grade);
    }
}

class Enrollment implements Graded {
    private Student student;
    private Course course;
    private String grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public void assignGrade(String grade) {
        this.grade = grade;
        double gpa = 0.0;
        switch (grade) {
            case "A": gpa = 4.0; break;
            case "B": gpa = 3.0; break;
            case "C": gpa = 2.0; break;
            case "D": gpa = 1.0; break;
            case "F": gpa = 0.0; break;
            case "Pass": gpa = 4.0; break;
            case "Fail": gpa = 0.0; break;
        }
        student.setGpa(gpa);
        System.out.println("Assigned grade " + grade + " to " + student.studentId + " in " + course.getCourseName());
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        Student s1 = new Undergraduate("S101", "Alice");
        Student s2 = new Postgraduate("S201", "Bob");

        Course c1 = new Course("C001", "Math");
        Course c2 = new Course("C002", "Physics");

        s1.enrollCourse(c1);
        s2.enrollCourse(c2);

        Enrollment e1 = new Enrollment(s1, c1);
        Enrollment e2 = new Enrollment(s2, c2);

        Faculty f1 = new Faculty("F101", "Dr. Smith");
        f1.assignGrade(e1, "A");
        f1.assignGrade(e2, "Pass");

        s1.displayTranscript();
        s2.displayTranscript();
    }
}
