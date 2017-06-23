package nl.bos.games.seabattle;

/**
 * Created by bosa on 22-6-2017.
 */
public class Ship implements IShip {
    private String type;
    private int size;
    private int locationX, locationY;
    private boolean isInBattle;
    private boolean isHorizontal;

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
