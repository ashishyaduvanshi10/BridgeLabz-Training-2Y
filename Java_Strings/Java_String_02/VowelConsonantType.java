import java.util.Scanner;

public class VowelConsonantType {
    static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] analyzeString(String s) {
        int index = 0;
        String[][] result = new String[getLength(s)][2];
        try {
            while (true) {
                char ch = s.charAt(index);
                result[index][0] = String.valueOf(ch);
                result[index][1] = checkCharType(ch);
                index++;
            }
        } catch (Exception e) {
            return result;
        }
    }

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

    static void displayTable(String[][] table) {
        System.out.println("Character\tType");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] table = analyzeString(text);
        displayTable(table);
    }
}
