import java.util.*;

public class StudentScorecard {
    static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(90);
            }
        }
        return scores;
    }

    static String[][] calculateResults(int[][] scores) {
        String[][] result = new String[scores.length][5];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double pct = Math.round((total / 3.0) * 100.0 / 100.0); // 2 digits not needed for integers but consistent
            result[i][0] = String.valueOf(total);
            result[i][1] = String.valueOf(Math.round(avg));
            result[i][2] = String.valueOf(Math.round(pct));
            result[i][3] = getGrade(pct);
            result[i][4] = ""; // placeholder if needed later
        }
        return result;
    }

    static String getGrade(double pct) {
        if (pct >= 80) return "A";
        else if (pct >= 70) return "B";
        else if (pct >= 60) return "C";
        else if (pct >= 50) return "D";
        else if (pct >= 40) return "E";
        else return "R";
    }

    static void displayScorecard(int[][] scores, String[][] results) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPct\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i+1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            for (int k = 0; k < 4; k++) {
                System.out.print(results[i][k] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        String[][] results = calculateResults(scores);
        displayScorecard(scores, results);
    }
}
