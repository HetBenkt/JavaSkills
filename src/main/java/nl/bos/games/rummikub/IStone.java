package nl.bos.games.rummikub;

import nl.bos.games.rummikub.impl.Stone;

/**
 * Created by bosa on 11-7-2017.
 * Interface for the Stone object
 */
public interface IStone {
    int getValue();
    Stone.COLOR getColor();
}
