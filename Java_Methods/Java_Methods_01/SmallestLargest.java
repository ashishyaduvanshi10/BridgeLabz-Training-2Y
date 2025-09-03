import java.util.Scanner;

public class SmallestLargest {
    public static int[] findSmallestAndLargest(int n1, int n2, int n3) {
        int min = n1, max = n1;
        if (n2 < min) min = n2;
        if (n3 < min) min = n3;
        if (n2 > max) max = n2;
        if (n3 > max) max = n3;
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int[] result = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
        sc.close();
    }
}
