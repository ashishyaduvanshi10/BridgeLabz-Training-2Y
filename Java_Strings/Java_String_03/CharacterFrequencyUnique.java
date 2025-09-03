import java.util.Scanner;

public class CharacterFrequencyUnique {
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

    static char[] uniqueCharacters(String s) {
        int len = getLength(s);
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (temp[j] == c) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[index] = c;
                index++;
            }
        }

        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    static String[][] findFrequency(String s) {
        int[] freq = new int[256];
        int len = getLength(s);

        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;
        }

        char[] unique = uniqueCharacters(s);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }

        return result;
    }

    static void displayFrequency(String[][] freqArr) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < freqArr.length; i++) {
            System.out.println(freqArr[i][0] + "\t\t" + Integer.parseInt(freqArr[i][1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] frequency = findFrequency(text);
        displayFrequency(frequency);
    }
}
