package nl.bos.games.rummikub.impl;

import lombok.*;
import lombok.extern.java.Log;
import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IStone;

import java.util.*;

/**
 * Created by bosa on 11-7-2017.
 * Contains the bag of stones from where a player can pick from
 * Could have a nice color-print property if we have a UI :)
 */
@Data
@Log
public class Bag implements IBag {
    public static final int MAX_SIZE = 106;
    private List<IStone> stones = new ArrayList<>();

    @Override
    public void addStones() {
        Stone.COLOR[] colors = Stone.COLOR.values();
        int index = 0;
        Stone.COLOR color = colors[index];

        //Add 104 stones with 14 numbers and 4 colors
        for (int i=1; i <= (MAX_SIZE-2)/Stone.MAX_NUMBER; i++){
            for (int number = 1; number <= Stone.MAX_NUMBER; number++) {
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
            log.info(String.format("Stone %d [value:%s, color:%s]", index, stone.getValue(), stone.getColor()));
            index++;
        }
    }

    @Override
    public void remove(IStone stone) {
        stones.remove(stone);
    }

    @Override
    public void add(List<IStone> stones) {
        for (IStone stone: stones) {
            this.stones.add(stone);
        }
    }
}
