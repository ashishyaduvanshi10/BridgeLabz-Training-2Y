interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*].*");
    }
}

public class PasswordCheck {
    public static void main(String[] args) {
        String pw1 = "Abc123!";
        String pw2 = "StrongP@ss1";

        System.out.println(pw1 + " strong? " + SecurityUtils.isStrongPassword(pw1));
        System.out.println(pw2 + " strong? " + SecurityUtils.isStrongPassword(pw2));
    }
}
