package nl.bos.games.loderunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bosa on 4-4-2017.
 */
public class PlayerKeyListener implements KeyListener {
    private Player player;

    public PlayerKeyListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setSpeed(1);
            player.moveLocationX();
        }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setSpeed(-1);
            player.moveLocationX();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            player.setSpeed(1);
            player.moveLocationY();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setSpeed(-1);
            player.moveLocationY();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
