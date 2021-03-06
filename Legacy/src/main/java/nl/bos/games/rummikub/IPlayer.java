package nl.bos.games.rummikub;

import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 * Interface for the Player object
 */
public interface IPlayer {
    void pickStones(IBag gameBag);
    List<IStone> getStones();
    void displayDesk();
    void display();
    void cleanDesk(IBag gameBag);
    void pickStone(IBag gameBag);
}
