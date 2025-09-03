import java.util.Scanner;

public class CharacterFrequency {
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

    static String[][] findFrequency(String s) {
        int[] freq = new int[256];
        int len = getLength(s);

        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;
        }

        String[][] result = new String[len][2];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (freq[c] > 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0;
                index++;
            }
        }

        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
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
