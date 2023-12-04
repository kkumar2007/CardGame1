import java.util.ArrayList;
public class Deck
{
    private ArrayList<Card> cards;
    private int cardsLeft;
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<>();
        cardsLeft = 0;

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                String rank = ranks[i];
                int point = values[i];
                cards.add(new Card(rank, suit, point));
                cardsLeft++;
            }
        }
        shuffle();
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal() {
        if (cards.isEmpty()) {
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    public void shuffle() {
        for (int i = cards.size() - 1; i > 0; i--) {
            int random = (int) (Math.random() * (i + 1));


            Card temp = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }

        cardsLeft = cards.size();
    }
}
