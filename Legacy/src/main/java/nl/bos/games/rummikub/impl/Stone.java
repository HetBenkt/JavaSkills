package nl.bos.games.rummikub.impl;

import nl.bos.games.rummikub.IStone;

/**
 * Created by bosa on 11-7-2017.
 * Each stone in the game has a color and a value
 * Joker is value 0 and has no color
 * 106 stones are in 1 game
 */
public class Stone implements IStone {
    public enum COLOR {BLACK, RED, BLUE, YELLOW}

    public static final int MAX_NUMBER = 13;

    private final int value;
    private final COLOR color;

    public Stone(int value, COLOR color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public COLOR getColor() {
        return color;
    }
}
