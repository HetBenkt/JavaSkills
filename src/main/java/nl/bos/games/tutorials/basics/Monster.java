package nl.bos.games.tutorials.basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
public class Monster {
    private int locationX;
    private int locationY;
    private final Image image;
    private static final int SCALE = 18;

    @Setter
    @Getter
    private int speedX;
    @Getter
    private boolean isVisible;

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, locationX, locationY, image.getWidth(null) / SCALE, image.getHeight(null) / SCALE, null);
    }

    public void move() {
        locationX -= speedX;
        if (locationX < 0)
            isVisible = false;
    }
}
