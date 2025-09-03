import java.util.*;

public class RockPaperScissors {
    static String getComputerChoice() {
        double r = Math.random();
        if (r < 0.33) return "rock";
        else if (r < 0.66) return "paper";
        else return "scissors";
    }

    static String getWinner(String user, String comp) {
        if (user.equals(comp)) return "draw";
        if (user.equals("rock") && comp.equals("scissors")) return "user";
        if (user.equals("paper") && comp.equals("rock")) return "user";
        if (user.equals("scissors") && comp.equals("paper")) return "user";
        return "computer";
    }

    static String[][] calculateStats(int userWins, int compWins, int games) {
        String[][] stats = new String[2][3];
        double userPct = (games == 0) ? 0 : (userWins * 100.0 / games);
        double compPct = (games == 0) ? 0 : (compWins * 100.0 / games);
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPct);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f", compPct);
        return stats;
    }

    static void displayResults(List<String[]> rounds, String[][] stats) {
        System.out.println("Game\tUser Choice\tComputer Choice\tWinner");
        for (int i = 0; i < rounds.size(); i++) {
            String[] r = rounds.get(i);
            System.out.println((i+1) + "\t" + r[0] + "\t\t" + r[1] + "\t\t" + r[2]);
        }
        System.out.println("\nPlayer Stats:");
        System.out.println("Name\tWins\tWin%");
        for (String[] s : stats) {
            System.out.println(s[0] + "\t" + s[1] + "\t" + s[2]);
        }
    }

    public static
