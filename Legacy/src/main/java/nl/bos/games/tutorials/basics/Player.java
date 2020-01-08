package nl.bos.games.tutorials.basics;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.Getter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static nl.bos.games.tutorials.basics.Settings.*;

public class Player extends Sprite {

    private final Image imageMissile;
    private final Media soundRocket;
    @Getter
    private final List<Missile> missiles = new ArrayList<>();

    public Player(Point point, Image image, boolean isVisible, int speedX, int speedY, int scale, Image imageMissile, Media soundRocket) {
        super(point, image, isVisible, speedX, speedY, scale);
        this.imageMissile = imageMissile;
        this.soundRocket = soundRocket;
    }

    public void move() {

        if (point.getX() <= BOARD_WIDTH - (image.getWidth(null) / scale) && point.getX() >= 0) {
            point.setLocation(point.getX() + speedX, point.getY());
        }
        else {
            if (point.getX() <= 0)
                point.setLocation(point.getX() + 1, point.getY());
            else
                point.setLocation(point.getX() - 1, point.getY());
        }

        if (point.getY() <= BOARD_HEIGHT - (image.getHeight(null) / scale) && point.getY() >= 0)
            point.setLocation(point.getX(), point.getY() + speedY);
        else {
            if (point.getY() <= 0)
                point.setLocation(point.getX(), point.getY() + 1);
            else
                point.setLocation(point.getX(), point.getY() - 1);
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
        Point missilePoint = new Point((int) point.getX() + 15, (int) point.getY() + 25);
        missiles.add(new Missile(missilePoint, imageMissile, 1, 0, true, 40));

        //Start the rocket launch sound
        MediaPlayer mediaPlayer = new MediaPlayer(soundRocket);
        mediaPlayer.play();
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
