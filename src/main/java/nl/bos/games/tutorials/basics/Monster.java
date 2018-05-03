package nl.bos.games.tutorials.basics;

import java.awt.*;

class Monster extends Sprite {

    public Monster(int locationX, int locationY, Image image, boolean isVisible, int speedX, int speedY, int scale) {
        super(locationX, locationY, image, isVisible, speedX, speedY, scale);
    }

    public void move() {
        locationX -= speedX;
        if (locationX < 0)
            isVisible = false;
    }
}
