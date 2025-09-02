import java.util.Scanner;

public class PersonBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight, height;

            while (true) {
                System.out.print("Person " + (i + 1) + " Weight (kg): ");
                weight = sc.nextDouble();
                System.out.print("Person " + (i + 1) + " Height (m): ");
                height = sc.nextDouble();

                if (weight <= 0 || height <= 0) {
                    System.out.println("Invalid input! Enter positive values.");
                } else {
                    break;
                }
            }

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson Data:");
        System.out.println("Weight(kg)  Height(m)  BMI       Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f       %.2f       %.2f    %s\n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
