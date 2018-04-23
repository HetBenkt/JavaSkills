package nl.bos.games.tutorials.basics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@AllArgsConstructor
@Data
public class Missile {

    private int locationX;
    private int locationY;
    private final Image image;
    private int speedX;
    private final static int SCALE = 50;
    private boolean isVisible;

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, locationX, locationY, image.getWidth(null) / SCALE, image.getHeight(null) / SCALE, null);
    }

    public void move() {
        locationX += speedX;
        if (locationX > Board.BOARD_WIDTH)
            isVisible = false;
    }
}
