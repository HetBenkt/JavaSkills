package nl.bos.games.loderunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/*
 * Created by bosa on 29-3-2017.
 */
public class PlayGround extends JPanel {
    private final static Color BACKGROUND_COLOR = new Color(0, 0, 0);
    private Ground ground;
    private Player player;
    private PlayerKeyListener keyboard;

    public PlayGround() {
        //this.setDoubleBuffered(true); //No Effect YET!
        this.setBackground(BACKGROUND_COLOR);
        this.setFocusable(true);
        //this.requestFocusInWindow(); //TODO Check what it does?

        //Init objects
        ground = new Ground(10);
        player = new Player(50, ground.getHeight(), 50, 0);
        keyboard = new PlayerKeyListener(player);
        this.addKeyListener(keyboard);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Ground
        ground.draw(g, this.getHeight(), this.getWidth());

        //Player
        player.draw(g, this.getHeight());
        keyboard.poll();
        if( keyboard.keyDown( KeyEvent.VK_RIGHT ) ) {
            player.setSpeed(1);
            player.moveLocationX();
        }
        else if( keyboard.keyDown( KeyEvent.VK_LEFT ) ) {
            player.setSpeed(-1);
            player.moveLocationX();
        }
        else if( keyboard.keyDown( KeyEvent.VK_UP ) ) {
            player.setSpeed(1);
            player.moveLocationY();
        }
        else if( keyboard.keyDown( KeyEvent.VK_DOWN ) ) {
            player.setSpeed(-1);
            player.moveLocationY();
        }
    }
}
