package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class LoadRunner extends JFrame {
    private boolean gameOver = false;
    private final static int GAME_SPEED = 5;

    private LoadRunner() throws InterruptedException {
        this.setTitle(this.getClass().getSimpleName());
        this.setSize(new Dimension(800, 600));
        this.setResizable(false);
        PlayGround playground = new PlayGround();
        this.setContentPane(playground);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        while(!gameOver) {
            playground.revalidate();
            playground.repaint();
            Thread.sleep(GAME_SPEED);
        }
    }

    public static void main(String[] args) {
        try {
            new LoadRunner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
