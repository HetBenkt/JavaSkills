package nl.bos.games.tutorials.basics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Player {

    private int locationX;
    private int locationY;
    private final Image imagePlayer, imageMissile;
    private int speedX;
    private int speedY;
    private final static int SPEED_ZERO = 0;
    private final static int SPEED = 8;
    private final static int SCALE = 10;
    private final List<Missile> missiles = new ArrayList<>();

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(imagePlayer, locationX, locationY, imagePlayer.getWidth(null) / SCALE, imagePlayer.getHeight(null) / SCALE, null);
    }

    public void move() {
        locationX += speedX;
        locationY += speedY;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                fire();
                break;
            case KeyEvent.VK_LEFT:
                if (locationX < 0)
                    speedX = SPEED_ZERO;
                else
                speedX = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                if (locationX > Board.BOARD_WIDTH-(imagePlayer.getWidth(null)/SCALE))
                    speedX = SPEED_ZERO;
                else
                    speedX = SPEED;
                break;
            case KeyEvent.VK_UP:
                if (locationY < 0)
                    speedY = SPEED_ZERO;
                else
                speedY = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                if (locationY > Board.BOARD_HEIGHT-(imagePlayer.getHeight(null)/SCALE))
                    speedY = SPEED_ZERO;
                else
                speedY = SPEED;
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
        }
    }
}
