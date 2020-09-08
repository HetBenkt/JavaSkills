package nl.bos.games.examples;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class AnimatedImage {
    private Image[] frames;
    private double duration;
    private Point2D location;

    public AnimatedImage(Point2D location) {
        this.location = location;
    }

    public Image getFrame(double time) {
        int index = (int)((time % (frames.length * duration)) / duration);
        return frames[index];
    }

    public void setFrames(Image[] frames) {
        this.frames = frames;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }

    public void moveHorizontal(int direction) {
        setLocation(new Point2D(location.getX()+direction, location.getY()));
    }

    public void moveVertical(int direction) {
        setLocation(new Point2D(location.getX(), location.getY()+direction));
    }
}
