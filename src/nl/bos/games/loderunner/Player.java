package nl.bos.games.loderunner;

import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class Player {
    private static int locationX;
    private static int locationY;
    private static int height;
    private final static Color PLAYER_COLOR = Color.WHITE;

    public Player(int locationX, int locationY, int height) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.height = height;
    }

    public void draw(Graphics g, int playGroundHeight) {
        g.setColor(PLAYER_COLOR);
        g.drawRect(locationX, playGroundHeight-locationY-height, height/2, height);
    }
}
