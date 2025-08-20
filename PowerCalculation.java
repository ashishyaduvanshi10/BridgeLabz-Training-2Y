import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base: ");
        double base = input.nextDouble();

        System.out.print("Enter the exponent: ");
        double exponent = input.nextDouble();

        double result = Math.pow(base, exponent);

        System.out.println("Result: " + result);

        input.close();
    }
}
