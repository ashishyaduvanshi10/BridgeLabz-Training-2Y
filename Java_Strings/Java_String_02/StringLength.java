import java.util.Scanner;

public class StringLength {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int lenCustom = getLength(str);
        int lenBuiltIn = str.length();
        System.out.println("Length (custom): " + lenCustom);
        System.out.println("Length (built-in): " + lenBuiltIn);
    }
}
