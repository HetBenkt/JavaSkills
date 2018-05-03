package nl.bos.games.tutorials.basics;

import lombok.Getter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static nl.bos.games.tutorials.basics.Settings.*;

public class Player extends Sprite {

    private final Image imageMissile;
    @Getter
    private final List<Missile> missiles = new ArrayList<>();

    public Player(int locationX, int locationY, Image image, boolean isVisible, int speedX, int speedY, int scale, Image imageMissile) {
        super(locationX, locationY, image, isVisible, speedX, speedY, scale);
        this.imageMissile = imageMissile;
    }

    public void move() {
        if (locationX <= BOARD_WIDTH - (image.getWidth(null) / scale) && locationX >= 0)
            locationX += speedX;
        else {
            if (locationX <= 0)
                locationX++;
            else
                locationX--;
        }

        if (locationY <= BOARD_HEIGHT - (image.getHeight(null) / scale) && locationY >= 0)
            locationY += speedY;
        else {
            if (locationY <= 0)
                locationY++;
            else
                locationY--;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                fire();
                break;
            case KeyEvent.VK_LEFT:
                speedX = -PLAYER_SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                speedX = PLAYER_SPEED;
                break;
            case KeyEvent.VK_UP:
                speedY = -PLAYER_SPEED;
                break;
            case KeyEvent.VK_DOWN:
                speedY = PLAYER_SPEED;
                break;
            default:
                break;
        }
    }

    private void fire() {
        missiles.add(new Missile(locationX + 15, locationY + 25, imageMissile, 1, 0, true, 50));
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                speedX = PLAYER_SPEED_ZERO;
                break;
            case KeyEvent.VK_RIGHT:
                speedX = PLAYER_SPEED_ZERO;
                break;
            case KeyEvent.VK_UP:
                speedY = PLAYER_SPEED_ZERO;
                break;
            case KeyEvent.VK_DOWN:
                speedY = PLAYER_SPEED_ZERO;
                break;
            default:
                break;
        }
    }
}
