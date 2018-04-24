package nl.bos.games.tutorials.basics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

@Log
@AllArgsConstructor
@Data
public class Player {

    private int locationX;
    private int locationY;
    private final Image imagePlayer;
    private final Image imageMissile;
    private int speedX;
    private int speedY;
    private static final int SPEED_ZERO = 0;
    private static final int SPEED = 3;
    private static final int SCALE = 10;
    private final List<Missile> missiles = new ArrayList<>();

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(imagePlayer, locationX, locationY, imagePlayer.getWidth(null) / SCALE, imagePlayer.getHeight(null) / SCALE, null);
    }

    public void move() {
        if (locationX <= Board.BOARD_WIDTH-(imagePlayer.getWidth(null)/SCALE) && locationX >= 0)
            locationX += speedX;
        else {
            if (locationX <= 0)
                locationX++;
            else
                locationX--;
        }

        if (locationY <= Board.BOARD_HEIGHT-(imagePlayer.getHeight(null)/SCALE) && locationY >= 0)
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
                speedX = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                speedX = SPEED;
                break;
            case KeyEvent.VK_UP:
                speedY = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                speedY = SPEED;
                break;
            default:
                break;
        }
    }

    private void fire() {
        missiles.add(new Missile(this.locationX + 15, this.locationY + 25, imageMissile, 1, true));
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                speedX = SPEED_ZERO;
                break;
            case KeyEvent.VK_RIGHT:
                speedX = SPEED_ZERO;
                break;
            case KeyEvent.VK_UP:
                speedY = SPEED_ZERO;
                break;
            case KeyEvent.VK_DOWN:
                speedY = SPEED_ZERO;
                break;
            default:
                break;
        }
    }
}
