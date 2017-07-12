package nl.bos.games.rummikub;

import lombok.Data;

import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 */
public interface IPlayer {
    String getName();
    int getAge();
    String getGender();
    void pickStones(IBag bag, int size);
    List<IStone> getStones();
    void displayDesk();
    void display();
}
