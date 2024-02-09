//Kavan Kumar
//CS2
//Dec 7, 2023
import javax.swing.ImageIcon;
import java.awt.*;

// Represents a playing card
public class Card {
    // The rank of the card
    private String rank;
    // The suit of the card
    private String suit;
    // The point value of the card
    private int point;
    private Image image;
    private final int Y_VAL = 300;

    // Constructor to initialize the card with rank, suit, and point
    public Card(String rank, String suit, int point, Image image) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
        this.image = image;

    }

    // Getter method to get the rank of the card
    public String getRank() {
        return rank;
    }

    // Setter method to set the rank of the card
    public void setRank(String rank) {
        this.rank = rank;
    }

    // Getter method to get the suit of the card
    public String getSuit() {
        return suit;
    }

    // Setter method to set the suit of the card
    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Getter method to get the point value of the card
    public int getPoint() {
        return point;
    }

    // Setter method to set the point value of the card
    public void setPoint(int point) {
        this.point = point;
    }

    // toString method to represent the card as a string
    public String toString() {
        return rank + " of " + suit;
    }
    public void draw(Graphics g, int x, BlackjackViewer view)
    {
        g.drawImage(image, x, Y_VAL, view);
    }
}
