package nl.bos.games.seabattle;

/**
 * The ship class with all it's properties and methods to execute
 */
public class Ship implements IShip {
    private final String type;
    private final int size;
    private int locationX, locationY;
    private boolean isInBattle;
    private final boolean isHorizontal;

    public Ship(String type, int size, boolean isHorizontal) {
        this.locationX = -1;
        this.locationY = -1;
        this.type = type;
        this.size = size;
        this.isHorizontal = isHorizontal;
        this.isInBattle = false;
    }

    public String getType() {
        return type;
    }

    public void setInBattle(boolean inBattle) {
        isInBattle = inBattle;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }
}
