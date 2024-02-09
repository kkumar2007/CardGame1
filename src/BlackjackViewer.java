import javax.swing.*;
import java.awt.*;

public class BlackjackViewer extends JFrame {
    private final int HEIGHT = 1000, WIDTH = 800,
            X_OFFSET = 100, Y_OFFSET = 100, BOX_SIZE = 180;
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
        g.drawImage(background, 0, 0, this);
        g.setColor(Color.WHITE);
        if (game.getState() == 0) {
            game.printInstructions();
            game.setState(1);

        }
        if (game.getState() == 1) {
            g.drawImage(play, 0, 0, this);
        }

        int x = X_OFFSET + 20;
        int y = Y_OFFSET - 30;
        for (int j = 0; j < 3; j++) {
            String n2 = String.valueOf(j);
            g.setFont(new Font("Serif", Font.PLAIN, 35));
            g.setColor(Color.RED);
            g.drawString(n2, x, y);
            x += BOX_SIZE + 50;

        }
        x = 50;
        y = 200;
        for (int i = 0; i < 3; i++) {
            String n = String.valueOf(i);
            g.setFont(new Font("Serif", Font.PLAIN, 35));
            g.drawString(n, x, y);
            y += 200;
        }
    }
}
