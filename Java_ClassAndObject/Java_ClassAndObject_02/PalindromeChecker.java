class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("madam");
        PalindromeChecker p2 = new PalindromeChecker("hello");

        p1.displayResult();
        p2.displayResult();
    }
}
