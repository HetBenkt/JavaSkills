package nl.bos.games.tutorials.basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.awt.*;

@Log
@AllArgsConstructor
public class Sprite {
    @Getter
    Point point;
    final Image image;
    @Setter
    @Getter
    boolean isVisible;
    @Setter
    @Getter
    int speedX;
    int speedY;
    final int scale;

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, (int) point.getX(), (int) point.getY(), image.getWidth(null) / scale, image.getHeight(null) / scale, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) point.getX(), (int) point.getY(), image.getWidth(null) / scale, image.getHeight(null) / scale);
    }
}
