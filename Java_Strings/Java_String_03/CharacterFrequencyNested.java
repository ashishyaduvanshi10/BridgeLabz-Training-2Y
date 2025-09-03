import java.util.Scanner;

public class CharacterFrequencyNested {
    static String[] findFrequency(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j] && chars[i] != '0') {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        String[] result = new String[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " = " + freq[i];
                index++;
            }
        }

        String[] finalResult = new String[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    static void displayFrequency(String[] freqArr) {
        System.out.println("Character\tFrequency");
        for (String entry : freqArr) {
            String[] parts = entry.split(" = ");
            System.out.println(parts[0] + "\t\t" + Integer.parseInt(parts[1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] frequency = findFrequency(text);
        displayFrequency(frequency);
    }
}
