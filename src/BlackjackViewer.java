import javax.swing.*;
import java.awt.*;

public class BlackjackViewer extends JFrame {
    private final int HEIGHT = 1000, WIDTH = 800,
            X_OFFSET = 100, Y_OFFSET = 100, LENGTH = 180;
    private Game game;
    private Image background;
    private Image play;

    public BlackjackViewer(Game game) {
        this.game = game;
        background = new ImageIcon("Resources/Cards/Blackjack.png").getImage();
        play = new ImageIcon("Resources/Cards/playing.png").getImage();

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int x = 50;
        int y = 600;
        g.drawImage(background, 0, 0, this);
        g.setColor(Color.WHITE);
        if (game.getState() == 0) {
        }
        if (game.getState() == 1) {
            g.drawImage(play, 0, 0, this);
            for (Card card : game.getPlayer().getHand())
            {
                Image cardImage = card.getImage();
                g.drawImage(cardImage, x, y, 100, 100, this);
                x += LENGTH + 50;
            }

        }
    }
}
