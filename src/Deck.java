import javax.swing.*;
import java.util.ArrayList;

// Represents a deck of playing cards
public class Deck {
    // List to store cards in the deck
    private ArrayList<Card> cards;
    // Number of cards left in the deck
    private int cardsLeft;

    // Constructor to initialize the deck with ranks, suits, and values
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<>();
        cardsLeft = 0;
        int j = 0;
        // Create cards for each rank and suit, add to the deck, and update cardsLeft
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                String rank = ranks[i];
                int point = values[i];
                j+=1;
                String n2 = String.valueOf(j);
                cards.add(new Card(rank, suit, point, new ImageIcon("Resources/Cards/" + n2 + ".png").getImage()));
                cardsLeft++;
            }
        }
        // Shuffle the deck after creating it
        shuffle();
    }

    // Getter method to get the number of cards left in the deck
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Method to deal a card from the deck
    public Card deal() {
        // Check if the deck is empty
        if (cards.isEmpty()) {
            return null;
        }
        cardsLeft--;
        // Return the top card and update cardsLeft
        return cards.get(cardsLeft);
    }

    // Method to shuffle the deck
    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            // Generate a random index between 0 and i (inclusive)
            int random = (int) (Math.random() * (i + 1));

            // Swap the card at index i with the card at the random index
            Card temp = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }
// Reset cardsLeft after shuffling
        cardsLeft = cards.size();
    }
}
