package nl.bos.games.rummikub;

import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 * Interface for the Player object
 */
public interface IPlayer {
    String getName();
    int getAge();
    String getGender();
    void pickStones(IBag bag);
    List<IStone> getStones();
    void displayDesk();
    void display();
}
