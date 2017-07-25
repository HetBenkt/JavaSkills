package nl.bos.games.rummikub.impl;


import lombok.Data;
import lombok.extern.java.Log;
import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IStone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 * Contains the information for the player like name, age, but also the desk with available stones to play with
 */
@Data
@Log
public class Player implements IPlayer {
    public static final int DESK_SIZE = 14;
    private final String name;
    private final int age;
    private final String gender;
    private List<IStone> stones = new ArrayList<>();

    @Override
    public void pickStones(IBag gameBag) {
        List<IStone> stonesInBag = gameBag.getStones();
        for (int i=0; i<DESK_SIZE; i++) {
            IStone stone = stonesInBag.get(i);
            stones.add(stone);
            gameBag.remove(stone);
        }
    }

    @Override
    public void pickStone(IBag gameBag) {
        IStone stone = gameBag.getStones().get(0);
        stones.add(stone);
        gameBag.remove(stone);
    }

    @Override
    public void displayDesk() {
        int index = 1;
        for (IStone stone: stones) {
            lomlog.info(String.format("Stone %s [value:%s, color:%s]", index, stone.getValue(), stone.getColor()));
            index++;
        }
    }

    @Override
    public void display() {
        lomlog.info(String.format("Player [name:%s, age:%s, gender:%s]", name, age, gender));
    }

    @Override
    public void cleanDesk(IBag gameBag) {
        gameBag.add(stones);
        stones.clear();
    }
}
