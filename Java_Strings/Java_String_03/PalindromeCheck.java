import java.util.Scanner;

public class PalindromeCheck {
    static boolean isPalindromeLogic1(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static boolean isPalindromeLogic2(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return isPalindromeLogic2(s, start + 1, end - 1);
    }

    static char[] reverseString(String s) {
        int len = s.length();
        char[] rev = new char[len];
        for (int i = 0; i < len; i++) {
            rev[i] = s.charAt(len - 1 - i);
        }
        return rev;
    }

    static boolean isPalindromeLogic3(String s) {
        char[] original = s.toCharArray();
        char[] reversed = reverseString(s);
        if (original.length != reversed.length) {
            return false;
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        boolean result1 = isPalindromeLogic1(text);
        boolean result2 = isPalindromeLogic2(text, 0, text.length() - 1);
        boolean result3 = isPalindromeLogic3(text);

        System.out.println("Logic 1 (Iterative): " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursive): " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (Using Arrays): " + (result3 ? "Palindrome" : "Not Palindrome"));
    }
}
