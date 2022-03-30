package nl.bos.games.rummikub.tests;

import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IRummikub;
import nl.bos.games.rummikub.IStone;
import nl.bos.games.rummikub.impl.Player;
import nl.bos.games.rummikub.impl.Rummikub;
import nl.bos.games.rummikub.impl.Stone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by bosa on 25-7-2017.
 * test class for the Rummikub game class
 */
class RummikubTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void addPlayer() {
        IRummikub game = new Rummikub();
        IPlayer player = new Player(null, 0, null);

        game.addPlayer(player);
        assertEquals(1, game.getGamePlayers().size());
    }

    @Test
    void createStonesSet() throws Exception {
        Class rummikubClass = Class.forName("nl.bos.games.rummikub.impl.Rummikub");
        Method method = rummikubClass.getDeclaredMethod("createStonesSet", int[].class, List.class);
        method.setAccessible(true);
        Object targetObject = rummikubClass.newInstance();

        List<IStone> stones = new ArrayList<>();
        for(int i=0; i<Player.DESK_SIZE; i++)
            stones.add(new Stone(0, Stone.COLOR.RED));

        //Valid input
        int[] validStoneChoices = {1,2,3};
        List<IStone> returnValidObject = (List<IStone>) method.invoke(targetObject, validStoneChoices, stones);
        assertEquals(validStoneChoices.length, returnValidObject.size());

        //Invalid input
        int[] invalidStoneChoices = {1,2,16};
        List<IStone> returnInvalidObject = (List<IStone>) method.invoke(targetObject, invalidStoneChoices, stones);
        assertNotEquals(invalidStoneChoices.length, returnInvalidObject.size());
    }
}