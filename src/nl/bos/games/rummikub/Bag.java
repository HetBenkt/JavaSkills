package nl.bos.games.rummikub;

import lombok.*;
import lombok.extern.java.Log;

import java.util.*;

/**
 * Created by bosa on 11-7-2017.
 */
@Data
@Log
public class Bag implements IBag {
    private final int size;
    private List<IStone> stones = new ArrayList();

    @Override
    public void addStones() {
        IStone.COLOR[] colors = IStone.COLOR.values();
        int index = 0;
        IStone.COLOR color = colors[index];

        //Add 104 stones with 14 numbers and 4 colors
        for (int i=1; i <= (size-2)/IStone.MAX_NUMBER; i++){
            for (int number = 1; number <= IStone.MAX_NUMBER; number++) {
                IStone stone = new Stone(number, color);
                stones.add(stone);
            }
            index++;
            if(index < colors.length) {
                color = colors[index];
            }
            else {
                index = 0;
                color = colors[index];
            }
        }

        //Add 2 Joker stones
        IStone joker = new Stone(0, null);
        stones.add(joker);
        stones.add(joker);
    }

    @Override
    public void scramble() {
        long seed = System.nanoTime();
        Collections.shuffle(stones, new Random(seed));
    }

    @Override
    public void display() {
        int index = 1;
        for (IStone stone: stones) {
            log.info(String.format("Stone %s [value:%s, color:%s]", index, stone.getValue(), stone.getColor()));
            index++;
        }
    }

    @Override
    public void remove(IStone stone) {
        stones.remove(stone);
    }
}
