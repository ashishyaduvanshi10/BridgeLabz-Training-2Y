import java.util.Scanner;

public class FirstNonRepeatingChar {
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

    static char findFirstNonRepeating(String s) {
        int[] freq = new int[256];
        int len = getLength(s);

        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;
        }

        for (int i = 0; i < len; i++) {
            if (freq[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char result = findFirstNonRepeating(text);
        if (result != '\0')
            System.out.println("First non-repeating character: " + result);
        else
            System.out.println("No non-repeating character found.");
    }
}
