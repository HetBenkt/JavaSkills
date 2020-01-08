package nl.bos.games.seabattle;

import java.awt.*;

/**
 * The ship class with all it's properties and methods to execute
 */
public class Ship implements IShip {
    private final String type;
    private final int size;
    private boolean isInBattle;
    private final boolean isHorizontal;
    private final Point[] coordinates;

    public Ship(String type, int size, boolean isHorizontal) {
        this.type = type;
        this.size = size;
        this.isHorizontal = isHorizontal;
        this.isInBattle = false;
        coordinates = new Point[size];
    }

    public String getType() {
        return type;
    }

    public void setInBattle(boolean inBattle) {
        isInBattle = inBattle;
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void addCoordinate(int x, int y, int index) {
        Point coordinate = new Point();
        coordinate.setLocation(x, y);
        this.coordinates[index] = coordinate;
    }

    public void removeCoordinate(int index) {
        Point coordinate = new Point();
        coordinate.setLocation(-1, -1);
        this.coordinates[index] = coordinate;
    }

    public Point[] getCoordinates() {
        return coordinates;
    }
}
