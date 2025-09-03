import java.util.Scanner;

public class SplitText {
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

    static String[] manualSplit(String s) {
        int len = getLength(s);
        int spaces = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') spaces++;
        }
        int[] spaceIndex = new int[spaces + 2];
        int idx = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }
        spaceIndex[0] = -1;
        spaceIndex[idx] = len;
        String[] words = new String[spaces + 1];
        for (int i = 0; i < words.length; i++) {
            int start = spaceIndex[i] + 1;
            int end = spaceIndex[i + 1];
            String w = "";
            for (int j = start; j < end; j++) {
                w += s.charAt(j);
            }
            words[i] = w;
        }
        return words;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] manual = manualSplit(text);
        String[] builtin = text.split(" ");
        boolean same = compareArrays(manual, builtin);
        System.out.println("Manual split:");
        for (String w : manual) System.out.println(w);
        System.out.println("Built-in split:");
        for (String w : builtin) System.out.println(w);
        System.out.println("Are both equal? " + same);
    }
}
