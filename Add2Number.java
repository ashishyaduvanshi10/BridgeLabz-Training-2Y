import java.util.Scanner;

public class AddNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // To take user input

        System.out.print("Enter first number: ");
        int num1 = input.nextInt(); // Read first number

        System.out.print("Enter second number: ");
        int num2 = input.nextInt(); // Read second number

        int sum = num1 + num2; // Add the numbers

        System.out.println("Sum = " + sum); // Print the result

        input.close(); // Close the scanner
    }
}
