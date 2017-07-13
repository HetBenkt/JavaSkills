package nl.bos.games.rummikub;

import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 * Interface for the Bag object
 */
public interface IBag {
    void addStones();
    List<IStone> getStones();
    void scramble();
    void display();
    void remove(IStone stone);
}
