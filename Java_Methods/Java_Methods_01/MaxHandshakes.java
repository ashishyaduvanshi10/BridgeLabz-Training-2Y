import java.util.Scanner;

public class MaxHandshakes {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int handshakes = calculateHandshakes(n);
        System.out.println("The maximum number of handshakes is " + handshakes);
        sc.close();
    }
}
