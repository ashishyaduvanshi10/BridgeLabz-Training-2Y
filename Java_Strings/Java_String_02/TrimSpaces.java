import java.util.Scanner;

public class TrimSpaces {
    static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    static int[] trimIndexes(String s) {
        int len = getLength(s);
        int start = 0;
        while (start < len) {
            if (s.charAt(start) != ' ') break;
            start++;
        }
        int end = len - 1;
        while (end >= 0) {
            if (s.charAt(end) != ' ') break;
            end--;
        }
        return new int[]{start, end};
    }

    static String makeSubstring(String s, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String a, String b) {
        int lenA = getLength(a);
        int lenB = getLength(b);
        if (lenA != lenB) return false;
        for (int i = 0; i < lenA; i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] indexes = trimIndexes(text);
        String customTrim = indexes[0] <= indexes[1] ? makeSubstring(text, indexes[0], indexes[1]) : "";
        String builtInTrim = text.trim();
        boolean isSame = compareStrings(customTrim, builtInTrim);
        System.out.println("Custom trimmed string: \"" + customTrim + "\"");
        System.out.println("Built-in trimmed string: \"" + builtInTrim + "\"");
        System.out.println("Are both same? " + isSame);
    }
}
