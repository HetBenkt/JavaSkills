package nl.bos.games.tutorials.basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
public class Missile {

    private int locationX;
    private int locationY;
    private final Image image;
    private static final int SCALE = 50;
    public static final int MAX_SPEED = 15;

    @Setter
    @Getter
    private int speedX;
    @Setter
    @Getter
    private boolean isVisible;

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, locationX, locationY, image.getWidth(null) / SCALE, image.getHeight(null) / SCALE, null);
    }

    public void move() {
        locationX += speedX;
        if (locationX > Board.BOARD_WIDTH)
            isVisible = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(locationX, locationY, image.getWidth(null) / SCALE, image.getHeight(null) / SCALE);
    }
}
