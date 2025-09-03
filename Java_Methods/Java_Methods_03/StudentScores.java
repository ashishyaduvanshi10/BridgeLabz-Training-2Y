import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = new int[n][3];
        double[][] results = new double[n][3];
        String[] remarks = new String[n];

        for (int i = 0; i < n; i++) {
            scores[i][0] = (int)(Math.random() * 100); // Physics
            scores[i][1] = (int)(Math.random() * 100); // Chemistry
            scores[i][2] = (int)(Math.random() * 100); // Math

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(percent * 100.0) / 100.0;

            if (percent >= 80)
                remarks[i] = "A";
            else if (percent >= 70)
                remarks[i] = "B";
            else if (percent >= 60)
                remarks[i] = "C";
            else if (percent >= 50)
                remarks[i] = "D";
            else if (percent >= 40)
                remarks[i] = "E";
            else
                remarks[i] = "F";
        }

        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t%\tRemark");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" +
                (int)results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + remarks[i]);
        }
    }
}
