package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class LoadRunner extends JFrame implements Runnable {
    private boolean gameOver = false;
    private final static int GAME_SPEED = 70;
    PlayGround playground;

    private LoadRunner() {
        this.setTitle(this.getClass().getSimpleName());
        this.setSize(new Dimension(800, 600));
        this.setResizable(false);

        //Create a playground
        playground = new PlayGround();
        this.setContentPane(playground);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoadRunner loadRunner = new LoadRunner();
        loadRunner.run();
    }

    @Override
    public void run() {
        while(!gameOver) {
            //playground.revalidate(); //Not needed
            playground.repaint();
            try {
                Thread.sleep(GAME_SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
