package nl.bos.games.tutorials.basics;

import java.awt.*;

public class Sprite {
    Point point;
    final Image image;
    boolean isVisible;
    int speedX;
    int speedY;
    final int scale;

    public Sprite(Point point, Image image, boolean isVisible, int speedX, int speedY, int scale) {
        this.point = point;
        this.image = image;
        this.isVisible = isVisible;
        this.speedX = speedX;
        this.speedY = speedY;
        this.scale = scale;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Image getImage() {
        return image;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getScale() {
        return scale;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, (int) point.getX(), (int) point.getY(), image.getWidth(null) / scale, image.getHeight(null) / scale, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) point.getX(), (int) point.getY(), image.getWidth(null) / scale, image.getHeight(null) / scale);
    }
}
