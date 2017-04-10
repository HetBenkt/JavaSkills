package nl.bos.games.loderunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bosa on 4-4-2017.
 */
public class PlayerKeyListener implements KeyListener {
    private Player player;

    private static final int KEY_COUNT = 256;

    private enum KeyState {
        RELEASED, // Not down
        PRESSED,  // Down, but not the first time
        ONCE      // Down for the first time
    }

    private boolean[] currentKeys = null;
    private KeyState[] keys = null;

    public PlayerKeyListener(Player player) {
        this.player = player;
        currentKeys = new boolean[KEY_COUNT];
        keys = new KeyState[KEY_COUNT];
        for (int i = 0; i < KEY_COUNT; ++i) {
            keys[i] = KeyState.RELEASED;
        }
    }

    public void poll() {
        for (int i = 0; i < KEY_COUNT; ++i) {
            // Set the key state
            if (currentKeys[i]) {
                // If the key is down now, but was not down last frame, set it to ONCE, otherwise, set it to PRESSED
                if (keys[i] == KeyState.RELEASED)
                    keys[i] = KeyState.ONCE;
                else
                    keys[i] = KeyState.PRESSED;
            } else {
                keys[i] = KeyState.RELEASED;
            }
        }
    }

    public boolean keyDown(int keyCode) {
        return keys[keyCode] == KeyState.ONCE || keys[keyCode] == KeyState.PRESSED;
    }

    public boolean keyDownOnce(int keyCode) {
        return keys[keyCode] == KeyState.ONCE;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //Not needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < KEY_COUNT) {
            currentKeys[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < KEY_COUNT) {
            currentKeys[keyCode] = false;
        }
    }
}