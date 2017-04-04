package nl.bos.games.loderunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bosa on 4-4-2017.
 */
public class PlayerKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
