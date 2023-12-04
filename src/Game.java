import java.util.Scanner;
//problem with point total
public class Game {
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};  // Ace can be 1 or 11

    private Player player;
    private Player dealer;
    private Deck deck;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        this.player = new Player(scanner.nextLine());
        this.dealer = new Player("Dealer");
        this.deck = new Deck(ranks, suits, values);
    }
    public void printInstructions()
    {
        System.out.println("Here are the rules:");
        System.out.print("Your goal in blackjack is to get as close" +
                "to 21 points as possible without going over(to beat the dealer).\n" +
                "The face cards are face points and the kings, jacks, queens count as 10.\n" +
                "But, the ace can count as either 1 or 11.");
    }
    public void playGame() {
        System.out.println("Welcome to Blackjack, " + player.getName() + "!");
        //Print Instructions.
        printInstructions();

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

    public void dealCard(Player player)
    {
        Card card = deck.deal();
        if (card != null) {
            player.addCard(card);
            int index = -1;
            for (int i = 0; i < ranks.length; i++)
            {
                if (ranks[i].equals(card.getRank()))
                {
                    index = i;
                    break;
                }
            }
            player.addPoints(values[index]);
        } else {
            System.out.println("The deck is empty!");
        }
    }

    public void playerTurn()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println(player);

            if (player.getPoints() == 21)
            {
                System.out.println("Blackjack! You win!");
                return;
            }

            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("h"))
            {
                dealCard(player);
                if (player.getPoints() > 21)
                {
                    System.out.println("Bust! You lose.");
                    return;
                }
            }
            else if (choice.equals("s"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
    }

    public void dealerTurn() {
        while (dealer.getPoints() < 17)
        {
            dealCard(dealer);
        }

        System.out.println(dealer);
    }

    public void determineWinner()
    {
        System.out.println(player);
        System.out.println(dealer);

        if (player.getPoints() > 21)
        {
            System.out.println("Bust! You lose.");
        }
        else if (dealer.getPoints() > 21)
        {
            System.out.println("Dealer busts! You win!");
        }
        else if (player.getPoints() == dealer.getPoints())
        {
            System.out.println("It's a push! Nobody wins.");
        }
        else if (player.getPoints() > dealer.getPoints())
        {
            System.out.println("You win!");
        }
        else
        {
            System.out.println("Dealer wins!");
        }
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.playGame();
    }
}
