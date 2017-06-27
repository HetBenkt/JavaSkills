package nl.bos.games.seabattle;

import java.awt.*;

/**
 * An interface for the ship (i think a good habit to do)
 */
interface IShip {
    void setInBattle(boolean inBattle);
    int getSize();
    boolean isHorizontal();
    String getType();
    void addCoordinate(int x, int y, int index);
    void removeCoordinate(int index);
    Point[] getCoordinates();
}
