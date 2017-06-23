package nl.bos.games.seabattle;

/**
 * Created by bosa on 22-6-2017.
 */
public interface IShip {
    void setInBattle(boolean inBattle);

    void setLocationX(int locationX);

    void setLocationY(int locationY);

    int getSize();

    boolean isHorizontal();

    String getType();
}
