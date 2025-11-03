public class GameScoreBoard {
    public static void main(String[] args) {
        Integer[] scores = {100, null, 80, null, 50};

        int nullCount = 0;
        int total = 0;

        for (Integer score : scores) {
            if (score == null)
                nullCount++;
            else
                total += score; 
        }

        System.out.println("Players who haven't played: " + nullCount);
        System.out.println("Total of valid scores: " + total);
    }
}

