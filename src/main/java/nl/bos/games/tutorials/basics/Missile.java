package nl.bos.games.tutorials.basics;

import lombok.extern.java.Log;

import java.awt.*;

import static nl.bos.games.tutorials.basics.Settings.BOARD_WIDTH;

@Log
class Missile extends Sprite {
    public Missile(int locationX, int locationY, Image image, int speedX, int speedY, boolean isVisible, int scale) {
        super(locationX, locationY, image, isVisible, speedX, speedY, scale);
    }

    public void move() {
        locationX += speedX;
        if (locationX > BOARD_WIDTH)
            isVisible = false;
    }
}
