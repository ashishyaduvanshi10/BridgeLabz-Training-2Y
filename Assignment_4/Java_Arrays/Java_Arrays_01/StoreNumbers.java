import java.util.Scanner;

public class StoreNumbers {
    public static void main(String[] args) {
        double[] values = new double[10];
        double sum = 0.0;
        int index = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number: ");
            double num = sc.nextDouble();
            if (num <= 0 || index == 10) break;
            values[index++] = num;
        }

        for (int i = 0; i < index; i++) {
            System.out.println(values[i]);
            sum += values[i];
        }

        System.out.println("Sum = " + sum);
        sc.close();
    }
}
