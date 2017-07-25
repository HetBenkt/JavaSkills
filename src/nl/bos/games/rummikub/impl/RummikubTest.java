package nl.bos.games.rummikub.impl;

import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IRummikub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bosa on 25-7-2017.
 * test class for the Rummikub game class
 */
class RummikubTest {
    @Test
    void addPlayer() {
        IRummikub game = new Rummikub();
        IPlayer player = new Player(null, 0, null);

        game.addPlayer(player);
        assertEquals(1, game.getGamePlayers().size());
    }
}