import java.util.Scanner;

public class WordsWithLength {
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

    static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = manualSplit(text);
        String[][] table = wordsWithLengths(words);
        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.valueOf(table[i][1]));
        }
    }
}
