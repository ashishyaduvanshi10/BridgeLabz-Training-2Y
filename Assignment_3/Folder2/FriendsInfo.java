import java.util.Scanner;

public class FriendsInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();

        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();

        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();

        String youngest = "";
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony)
            youngest = "Amar";
        else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony)
            youngest = "Akbar";
        else
            youngest = "Anthony";

        String tallest = "";
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony)
            tallest = "Amar";
        else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony)
            tallest = "Akbar";
        else
            tallest = "Anthony";

        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);

        sc.close();
    }
}
