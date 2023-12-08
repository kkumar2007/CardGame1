import java.util.ArrayList;

// Represents a player in the Blackjack game
public class Player {
    // Player's name
    private String name;
    // List of cards in the player's hand
    private ArrayList<Card> hand;
    // Total points of the player
    private int points;

    // Constructors

    // Constructor with only the player's name, initializes an empty hand and 0 points
    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.hand = new ArrayList<>();
    }

    // Constructor with both name and an existing hand
    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.points = 0;
        this.hand = hand;
    }

    // Getter methods

    // Returns the player's name
    public String getName() {
        return name;
    }

    // Returns the player's hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Returns the total points of the player
    public int getPoints() {
        return points;
    }

    // Method to add points to the player's total
    public void addPoints(int pointsToAdd) {
        if (pointsToAdd == 11) {
            // If adding 11 points would exceed 21, add only 1 point
            if (this.points + 11 > 21) {
                this.points += 1;
            } else {
                this.points += 11;
            }
        } else {
            this.points += pointsToAdd;
        }
    }

    // Method to add a card to the player's hand
    public void addCard(Card card) {
        this.hand.add(card);
    }

    // toString method to represent the player's information as a string
    public String toString() {
        return name + " has " + points + " points\n" + name + "'s cards: " + hand;
    }
}
