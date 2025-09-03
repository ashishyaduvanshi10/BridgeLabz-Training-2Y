import java.util.Scanner;

public class StringCompare {
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        boolean manualResult = compareUsingCharAt(str1, str2);
        boolean builtInResult = str1.equals(str2);
        System.out.println("Manual comparison result: " + manualResult);
        System.out.println("Built-in equals() result: " + builtInResult);
        System.out.println("Do both methods agree? " + (manualResult == builtInResult));
        sc.close();
    }
}
