import java.time.*;

class LateSubmissionException extends Exception {
    public LateSubmissionException(String message) {
        super(message);
    }
}


class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

public class OnlineExamSubmission {

    
    private static final LocalDateTime DEADLINE = LocalDateTime.of(2025, 11, 1, 18, 0); // Nov 1, 2025, 6:00 PM

    
    public static void submitExam(String fileName, LocalDateTime submissionTime)
            throws LateSubmissionException, InvalidFileFormatException {

        
        if (!fileName.endsWith(".pdf")) {
            throw new InvalidFileFormatException("Submission failed: invalid file format. Please upload a .pdf file.");
        }

    
        if (submissionTime.isAfter(DEADLINE)) {
            throw new LateSubmissionException("Submission failed: Your submission is late!");
        }

    
        System.out.println(" Submission successful! File: " + fileName);
    }


    public static void main(String[] args) {
        System.out.println("=== Online Exam Submission System ===");

        
        try {
        
            submitExam("ExamAnswers.pdf", LocalDateTime.of(2025, 11, 1, 17, 45)); // before deadline
        } 
        catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            
            submitExam("ExamAnswers.docx", LocalDateTime.of(2025, 11, 1, 17, 50));
        } 
        catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            
            submitExam("ExamAnswers.pdf", LocalDateTime.of(2025, 11, 1, 18, 30)); // after deadline
        } 
        catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== End of Program ===");
    }
}
