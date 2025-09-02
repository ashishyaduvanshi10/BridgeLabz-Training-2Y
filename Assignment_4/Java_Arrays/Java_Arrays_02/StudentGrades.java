import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            double physics, chemistry, maths;

            while (true) {
                System.out.print("Student " + (i + 1) + " Physics marks: ");
                physics = sc.nextDouble();
                System.out.print("Student " + (i + 1) + " Chemistry marks: ");
                chemistry = sc.nextDouble();
                System.out.print("Student " + (i + 1) + " Maths marks: ");
                maths = sc.nextDouble();

                if (physics < 0 || physics > 100 || chemistry < 0 || chemistry > 100 || maths < 0 || maths > 100) {
                    System.out.println("Invalid input! Enter marks between 0 and 100.");
                } else {
                    break;
                }
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;

            percentage[i] = (physics + chemistry + maths) / 3;

            if (percentage[i] >= 90) grade[i] = "A+";
            else if (percentage[i] >= 80) grade[i] = "A";
            else if (percentage[i] >= 70) grade[i] = "B";
            else if (percentage[i] >= 60) grade[i] = "C";
            else if (percentage[i] >= 50) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("\nStudent Marks, Percentage and Grade:");
        System.out.println("Physics  Chemistry  Maths  Percentage  Grade");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f      %.2f       %.2f     %.2f       %s\n",
                    marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
    }
}
