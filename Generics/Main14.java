import java.util.*;

abstract class CourseType {
    String courseName;
    CourseType(String courseName) {
        this.courseName = courseName;
    }
    public String toString() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName) {
        super(courseName);
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();
    public void addCourse(T course) {
        courseList.add(course);
    }
    public List<T> getCourses() {
        return courseList;
    }
}

class University {
    public static void printCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

public class Main14 {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>();
        examCourse.addCourse(new ExamCourse("Mathematics"));
        examCourse.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentCourse = new Course<>();
        assignmentCourse.addCourse(new AssignmentCourse("Computer Science"));
        assignmentCourse.addCourse(new AssignmentCourse("English"));

        Course<ResearchCourse> researchCourse = new Course<>();
        researchCourse.addCourse(new ResearchCourse("Artificial Intelligence"));
        researchCourse.addCourse(new ResearchCourse("Quantum Computing"));

        University.printCourses(examCourse.getCourses());
        University.printCourses(assignmentCourse.getCourses());
        University.printCourses(researchCourse.getCourses());
    }
}
