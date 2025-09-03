import java.util.Scanner;

public class DeckOfCards {
    static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }

    static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    static String[][] distributeCards(String[] deck, int nCards, int nPlayers) {
        if (nCards % nPlayers != 0) {
            return null;
        }
        int cardsPerPlayer = nCards / nPlayers;
        String[][] players = new String[nPlayers][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < nPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index];
                index++;
            }
        }
        return players;
    }

    static void printPlayers(String[][] players) {
        if (players == null) {
            System.out.println("Cards cannot be distributed equally among players.");
            return;
        }
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", 
                          "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int nCards = sc.nextInt();
        System.out.print("Enter number of players: ");
        int nPlayers = sc.nextInt();

        String[][] players = distributeCards(deck, nCards, nPlayers);
        printPlayers(players);
    }
}
