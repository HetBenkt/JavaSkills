package nl.bos.games.rummikub;

import lombok.Data;

/**
 * Created by bosa on 11-7-2017.
 */
public interface IPlayer {
    String getName();

    int getAge();

    String getGender();

    void pickStones(IBag bag, int size);
}
