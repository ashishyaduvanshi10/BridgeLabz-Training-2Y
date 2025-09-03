import java.util.Scanner;

public class ShortestLongestWord {
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

    static int[] findMinMax(String[][] table) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLen = Integer.valueOf(table[0][1]);
        int maxLen = minLen;
        for (int i = 1; i < table.length; i++) {
            int len = Integer.valueOf(table[i][1]);
            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = manualSplit(text);
        String[][] table = wordsWithLengths(words);
        int[] minMax = findMinMax(table);
        System.out.println("Shortest word: " + table[minMax[0]][0] + " (length " + table[minMax[0]][1] + ")");
        System.out.println("Longest word: " + table[minMax[1]][0] + " (length " + table[minMax[1]][1] + ")");
    }
}
