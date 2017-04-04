package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class PlayGround extends JPanel {
    private final static Color BACKGROUND_COLOR = new Color(0, 0, 0);
    private Ground ground = new Ground(10);
    private Player player = new Player(50, ground.getHeight(), 50, 0);


    public PlayGround() {
        //this.setDoubleBuffered(true); //No Effect YET!
        this.setBackground(BACKGROUND_COLOR);
        this.setFocusable(true);
        //this.requestFocusInWindow(); //TODO Check what it does?
        this.addKeyListener(new PlayerKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Ground
        ground.draw(g, this.getHeight(), this.getWidth());

        //Player
        player.draw(g, this.getHeight());
        player.setSpeed(1);
        player.moveLocationX();
    }
}
