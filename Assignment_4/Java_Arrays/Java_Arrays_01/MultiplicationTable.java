import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] results = new int[4];

        for (int i = 6; i <= 9; i++) {
            results[i - 6] = number * i;
            System.out.println(number + " * " + i + " = " + results[i - 6]);
        }
    }
}
