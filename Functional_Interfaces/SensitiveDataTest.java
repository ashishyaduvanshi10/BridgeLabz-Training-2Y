interface SensitiveData {
}

class UserCredentials implements SensitiveData {
    String username;
    String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return "UserCredentials[username=" + username + ", password=" + password + "]";
    }
}

public class SensitiveDataTest {
    public static void main(String[] args) {
        UserCredentials user = new UserCredentials("alice", "pass123");

        if (user instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + user);
        }
    }
}
