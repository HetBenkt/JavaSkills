package nl.bos.games.seabattle;

/**
 * An interface for the ship (i think a good habit to do)
 */
interface IShip {
    void setInBattle(boolean inBattle);

    void setLocationX(int locationX);

    void setLocationY(int locationY);

    int getSize();

    boolean isHorizontal();

    String getType();
}
