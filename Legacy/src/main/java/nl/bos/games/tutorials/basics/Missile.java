package nl.bos.games.tutorials.basics;

import lombok.extern.java.Log;

import java.awt.*;

import static nl.bos.games.tutorials.basics.Settings.BOARD_WIDTH;

@Log
class Missile extends Sprite {
    public Missile(Point point, Image image, int speedX, int speedY, boolean isVisible, int scale) {
        super(point, image, isVisible, speedX, speedY, scale);
    }

    public void move() {
        point.setLocation(point.getX() + speedX, point.getY());

        if (point.getX() > BOARD_WIDTH)
            isVisible = false;
    }
}
