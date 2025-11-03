import java.util.Scanner;


class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}


class LoginSystem {
    private String validUsername = "admin";
    private String validPassword = "1234";

    
    public void validate(String user, String pass) throws InvalidCredentialsException {
        if (!user.equals(validUsername) || !pass.equals(validPassword)) {
            throw new InvalidCredentialsException("Invalid username or password!");
        }
        System.out.println("Login successful! Welcome, " + user + "!");
    }
}


public class MainLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginSystem login = new LoginSystem();

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            try {
                login.validate(username, password);
                loggedIn = true; // login successful
            } catch (InvalidCredentialsException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again.\n");
            }
        }

        sc.close();
    }
}
