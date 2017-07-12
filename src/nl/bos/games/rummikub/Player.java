package nl.bos.games.rummikub;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 */
@Data
@Log
public class Player implements IPlayer {
    private final String name;
    private final int age;
    private final String gender;
    private List<IStone> stones = new ArrayList();;

    @Override
    public void pickStones(IBag bag, int size) {
        List<IStone> stonesInBag = bag.getStones();
        for (int i=0; i<size; i++) {
            IStone stone = stonesInBag.get(i);
            stones.add(stone);
            bag.remove(stone);
        }

    }

    @Override
    public void displayDesk() {
        int index = 1;
        for (IStone stone: stones) {
            log.info(String.format("Stone %s [value:%s, color:%s]", index, stone.getValue(), stone.getColor()));
            index++;
        }
    }

    @Override
    public void display() {
        log.info(String.format("Player [name:%s, age:%s, gender:%s]", name, age, gender));
    }
}
