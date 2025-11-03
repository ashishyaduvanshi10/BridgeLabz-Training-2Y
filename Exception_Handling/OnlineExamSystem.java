import java.io.*;

class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) {
        super(message);
    }
}


public class OnlineExamSystem {

    
    public static void validateStudent(String studentId) throws InvalidStudentException {
        
        if (!studentId.equals("STU123")) {
            throw new InvalidStudentException(" Invalid Student ID! Access denied for student: " + studentId);
        }
        System.out.println("✅ Student validation successful for: " + studentId);
    }

    public static void submitExam(String studentId) throws InvalidStudentException, IOException {
    
        validateStudent(studentId);

        
        if (Math.random() < 0.5) { 
            throw new IOException("Network error! Unable to submit exam at this moment.");
        }

        System.out.println("✅ Exam submitted successfully for " + studentId + ".");
    }

    
    public static void main(String[] args) {
        System.out.println("===  Online Exam System ===");

        try {
            
            submitExam("STU999"); 

        } catch (InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Exam submission process completed.");
        }
    }
}
