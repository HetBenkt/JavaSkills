package nl.bos.games.tutorials.basics;

import java.awt.*;

class Monster extends Sprite {

    public Monster(Point point, Image image, boolean isVisible, int speedX, int speedY, int scale) {
        super(point, image, isVisible, speedX, speedY, scale);
    }

    public void move() {
        point.setLocation(point.getX() - speedX, point.getY());
        if (point.getX() < 0)
            isVisible = false;
    }
}
