package nl.bos.games.loderunner;

import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class Player {
    private static int locationX;
    private static int speed;
    private static int locationY;
    private static int height;
    private final static Color PLAYER_COLOR = Color.WHITE;

    public Player(int locationX, int locationY, int height, int speed) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
        this.speed = speed;
    }

    public void draw(Graphics g, int playGroundHeight) {
        g.setColor(PLAYER_COLOR);
        g.drawRect(locationX, playGroundHeight-locationY-height, height/2, height);
    }

    public void moveLocationX() {
        locationX += speed;
    }

    public void moveLocationY() {
        locationY += speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLocationX() {
        return locationX;
    }
}
