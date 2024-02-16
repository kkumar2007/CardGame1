import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BlackjackViewer extends JFrame {
    private final int HEIGHT = 1000, WIDTH = 800,
            X_OFFSET = 100, Y_OFFSET = 100, LENGTH = 180;
    private Game game;
    private Image background;
    private Image play;

    private Image finale;

    public BlackjackViewer(Game game) {
        this.game = game;
        background = new ImageIcon("Resources/Cards/Start.png").getImage();
        play = new ImageIcon("Resources/Cards/playing.png").getImage();
        finale = new ImageIcon("Resources/Cards/end.png").getImage();

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Blackjack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int x = 50;
        int y = 600;
        g.setColor(Color.WHITE);
        if (game.getState() == 0) {
            g.drawImage(background, 0, 0, this);
        }
        if (game.getState() == 1) {
            g.drawImage(play, 0, 0, this);
            drawHand(g, game.getPlayer().getHand(), 50, 600);
            String number = String.valueOf(game.getPlayer().getPoints());
            g.setColor(Color.BLACK);
            int fontSize = 100;
            Font f = new Font("TimesRoman Bold", Font.BOLD, fontSize);
            g.drawString(number, 310, 200);
            drawHand(g, game.getDealer().getHand(), 50, 100);
            fontSize = 20;
            g.setFont(f);
            Font l = new Font("TimesRoman Bold", Font.BOLD, fontSize);
            g.setFont(l);

        }
        if (game.getState() == 2) {
            g.drawImage(finale, 0, 0, this);
            g.drawString("Sorry! You Lose", 100, 400);
            g.drawString(game.getPlayer().toString(), 100, 600);
            g.drawString(game.getDealer().toString(), 100, 700);

        }
        if (game.getState() == 3) {
            g.drawImage(finale, 0, 0, this);
            g.drawString("Congrats, You Won!", 100, 400);
            g.drawString(game.getPlayer().toString(), 100, 600);
            g.drawString(game.getDealer().toString(), 100, 700);
        }
        if (game.getState() == 4) {
            g.drawImage(finale, 0, 0, this);
            g.drawString("It's a tie!", 100, 400);
            g.drawString(game.getPlayer().toString(), 100, 600);
            g.drawString(game.getDealer().toString(), 100, 700);
        }


    }
    public void drawHand(Graphics g, ArrayList<Card> hand, int startX, int y) {
        int x = startX;
        for (Card card : hand) {
            Image cardImage = card.getImage();
            g.drawImage(cardImage, x, y, 100, 100, this);
            x += 30; // Adjust for overlap
        }
    }
}
