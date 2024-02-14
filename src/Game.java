import java.util.Scanner;

// The main class representing the Blackjack game
public class Game {
    // Arrays to store ranks, suits, and values of cards
    private String[] ranks = {"Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King",};
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs",};
    private int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};  // Ace can be 1 or 11

    // Players and deck of cards
    private Player player;
    private Player dealer;
    private Deck deck;
    private BlackjackViewer window;
    public static int state = 0;

    // Constructor to initialize the game
    public Game() {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Prompt user for player name and initialize player, dealer, and deck
        System.out.print("Enter player name: ");
        this.player = new Player(scanner.nextLine());
        state = 1;
        this.dealer = new Player("Dealer");
        this.deck = new Deck(ranks, suits, values);
        this.window = new BlackjackViewer(this);
    }
    public Player getPlayer()
    {
        return player;
    }

    // Method to print game instructions
    public void printInstructions() {
        System.out.println("Here are the rules:");
        System.out.println("Your goal in blackjack is to get as close to 21 points as possible without going over (to beat the dealer).\n" +
                "The face cards are worth 10 points, and the kings, jacks, queens count as 10.\n" +
                "However, the ace can count as either 1 or 11.");
    }

    // Method to start and play the game
    public void playGame() {
        boolean start = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack, " + player.getName() + "!");
        // Print game instructions
        while (true) {
            System.out.println("Ready to play? (Y/N): ");
            String start1 = scanner.nextLine();
            if (start1.equalsIgnoreCase("Y")) {
                start = true;
                break;
            } else if (start1.equalsIgnoreCase("N")) {
                System.out.println("Thank you for considering Blackjack. Goodbye!");
                return;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }


            // Initial deal
            dealCard(player);
            dealCard(dealer);
            dealCard(player);
            dealCard(dealer);

            // Player's turn
            playerTurn();

            // Dealer's turn
            dealerTurn();

            // Determine the winner
            determineWinner();
        }

    // Method to deal a card to a player and update points
    public void dealCard(Player player) {
        Card card = deck.deal();
        if (card != null) {
            player.addCard(card);
            int index = -1;
            // Find the index of the card's rank in the ranks array
            for (int i = 0; i < ranks.length; i++) {
                if (ranks[i].equals(card.getRank())) {
                    index = i;
                    break;
                }
            }
            // Add the corresponding value to the player's points
            player.addPoints(values[index]);
        } else {
            System.out.println("The deck is empty!");
        }
    }

    // Method representing the player's turn
    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(player);

            if (player.getPoints() == 21) {
                System.out.println("Blackjack! You win!");
                return;
            }
            window.repaint();
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("h")) {
                dealCard(player);
                if (player.getPoints() > 21) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
    }

    // Method representing the dealer's turn
    public void dealerTurn() {
        while (dealer.getPoints() < 17) {
            dealCard(dealer);
        }

        System.out.println(dealer);
    }

    // Method to determine the winner of the game
    public void determineWinner() {
        System.out.println(player);
        System.out.println(dealer);

        if (player.getPoints() > 21) {
            System.out.println("Bust! You lose.");
        } else if (dealer.getPoints() > 21) {
            System.out.println("Dealer busts! You win!");
        } else if (player.getPoints() == dealer.getPoints()) {
            System.out.println("It's a push! Nobody wins.");
        } else if (player.getPoints() > dealer.getPoints()) {
            System.out.println("You win!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
    public int getState()
    {
        return state;
    }
    public void setState(int number)
    {
        state = number;
    }



    // Main method to create and play the game
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
