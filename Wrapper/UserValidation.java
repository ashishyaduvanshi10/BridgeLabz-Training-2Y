public class UserValidation {
    public static boolean validateAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testAges = {"20", "17", "abc", "25"};

        for (String age : testAges) {
            System.out.println("Input: " + age + " → Valid: " + validateAge(age));
        }
    }
}
