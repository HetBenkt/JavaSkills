package nl.bos.games.rummikub.tests;

import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IStone;
import nl.bos.games.rummikub.impl.Bag;
import nl.bos.games.rummikub.impl.Stone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bosa on 21-7-2017.
 * Test class for the Bag object
 */
class BagTest {
    private IBag bag;
    private List<IStone> stones;
    private IStone stone;

    @BeforeEach
    void setUp() {
        bag = new Bag();
        stones = new ArrayList<>();
        stone = new Stone(0, Stone.COLOR.RED);
    }

    @AfterEach
    void tearDown() {
        stone = null;
        stones = null;
        bag = null;
    }

    @Test
    void addStones() {
        bag.addStones();
        assertEquals(Bag.MAX_SIZE, bag.getStones().size());
    }

    @Test
    void remove() {
        add();
        bag.remove(stone);
        assertEquals(0, bag.getStones().size());
    }

    @Test
    void add() {
        stones.add(stone);
        bag.add(stones);
        assertEquals(1, bag.getStones().size());
        assertEquals(0, bag.getStones().get(0).getValue());
        assertEquals(Stone.COLOR.RED, bag.getStones().get(0).getColor());
    }
}