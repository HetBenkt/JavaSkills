package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class LoadRunner extends JFrame {

    private LoadRunner() {
        this.setTitle(this.getClass().getSimpleName());
        this.setSize(new Dimension(800, 600));
        this.setResizable(false);
        PlayGround playground = new PlayGround();
        this.setContentPane(playground);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LoadRunner();
    }
}
