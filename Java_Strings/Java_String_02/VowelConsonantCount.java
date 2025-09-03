import java.util.Scanner;

public class VowelConsonantCount {
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

    static int[] countVowelsConsonants(String s) {
        int vowels = 0;
        int consonants = 0;
        int index = 0;
        try {
            while (true) {
                char ch = s.charAt(index);
                String type = checkCharType(ch);
                if (type.equals("Vowel")) vowels++;
                else if (type.equals("Consonant")) consonants++;
                index++;
            }
        } catch (Exception e) {
            return new int[]{vowels, consonants};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] result = countVowelsConsonants(text);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }
}
