package nl.bos.games.loderunner;

import java.awt.*;

/*
 * Created by bosa on 29-3-2017.
 */
public class Ground {
    private static int locationY;
    private final static Color GROUND_COLOR = Color.GREEN;

    public Ground(int locationY) {
        this.locationY = locationY;
    }

    public void draw(Graphics g, int playGroundHeight, int playGroundWidth) {
        g.setColor(GROUND_COLOR);
        g.drawLine(0, playGroundHeight-locationY, playGroundWidth, playGroundHeight-locationY);
    }

    public int getHeight() {
        return locationY;
    }
}
