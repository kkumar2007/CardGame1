import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;

    // Constructors
    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.hand = new ArrayList<>();
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.points = 0;
        this.hand = hand;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    // Method to add points
    public void addPoints(int pointsToAdd) {
        if (pointsToAdd == 11) {
            // Check if adding 11 points would exceed 21, if so, add only 1 point
            if (this.points + 11 > 21) {
                this.points += 1;
            } else {
                this.points += 11;
            }
        } else {
            this.points += pointsToAdd;
        }
    }

    // Method to add a card to the hand
    public void addCard(Card card) {
        this.hand.add(card);
    }

    // toString method
    @Override
    public String toString() {
        return name + " has " + points + " points\n" + name +"s" + " cards: " + hand;
    }
}
