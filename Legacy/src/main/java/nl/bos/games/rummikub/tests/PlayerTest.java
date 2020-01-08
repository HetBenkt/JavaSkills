package nl.bos.games.rummikub.tests;

import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.impl.Bag;
import nl.bos.games.rummikub.impl.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bosa on 21-7-2017.
 * Test class for the Player object
 */
class PlayerTest {
    private IPlayer player;
    private IBag bag;

    @BeforeEach
    void setUp() {
        player = new Player(null, 0, null);
        bag = new Bag();
        bag.addStones();
        assertEquals(Bag.MAX_SIZE, bag.getStones().size());
    }

    @AfterEach
    void tearDown() {
        player = null;
        bag = null;
    }

    @Test
    void pickStones() {
        player.pickStones(bag);
        assertEquals(Player.DESK_SIZE, player.getStones().size());
        assertEquals(Bag.MAX_SIZE-Player.DESK_SIZE, bag.getStones().size());
    }

    @Test
    void pickStone() {
        player.pickStone(bag);
        assertEquals(1, player.getStones().size());
        assertEquals(Bag.MAX_SIZE-1, bag.getStones().size());
    }

    @Test
    void cleanDesk() {
        pickStones();
        player.cleanDesk(bag);
        assertEquals(0, player.getStones().size());
        assertEquals(Bag.MAX_SIZE, bag.getStones().size());
    }
}