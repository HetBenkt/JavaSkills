package nl.bos.games.rummikub.tests;

import nl.bos.games.rummikub.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bosa on 11-7-2017.
 */
public class TestRummikub {
    public static final String ANTAL = "Antal";
    public static final String KIM = "Kim";
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final int AGE_36 = 36;
    public static final int AGE_33 = 33;
    public static final int SIZE = 106;
    public static final int DESK_SIZE = 14;

    private static Rummikub game;
    private static IPlayer player1, player2;
    private static IBag bag;

    @BeforeAll
    public static void initGame() {
        //Game object
        game = new Rummikub();

        //Player objects
        player1 = new Player(ANTAL, AGE_36, MALE);
        player2 = new Player(KIM, AGE_33, FEMALE);
        game.addPlayer(player1);
        game.addPlayer(player2);

        //Bag object
        bag = new Bag(SIZE);
        bag.addStones();
        bag.scramble();
        bag.display();
        game.addBagOfStones(bag);
    }

    @Test
    public void testGamePlayers() {
        List<IPlayer> players = game.getPlayers();
        IPlayer testPlayer1 = new Player(ANTAL, AGE_36, MALE);
        IPlayer testPlayer2 = new Player(KIM, AGE_33, FEMALE);

        assertEquals(testPlayer1.getName(), player1.getName());
        assertEquals(testPlayer2.getName(), player2.getName());
        assertEquals(testPlayer1.getAge(), player1.getAge());
        assertEquals(testPlayer2.getAge(), player2.getAge());
        assertEquals(testPlayer1.getGender(), player1.getGender());
        assertEquals(testPlayer2.getGender(), player2.getGender());
    }

    @Test
    public void testBagInitialization() {
        IBag bag = game.getBag();
        List<IStone> stones = bag.getStones();

        IBag testBag = new Bag(SIZE);
        testBag.addStones();
        testBag.scramble();
        List<IStone> testStones = testBag.getStones();

        assertEquals(testStones.size(), stones.size());
        assertEquals(SIZE, stones.size());
        assertEquals(SIZE, testStones.size());
    }

    @Test
    public void testPickingStones() {
        player1.pickStones(bag, DESK_SIZE);
        player1.display();
        player1.displayDesk();
        assertEquals(DESK_SIZE, player1.getStones().size());

        player2.pickStones(bag, DESK_SIZE);
        player2.display();
        player2.displayDesk();
        assertEquals(DESK_SIZE, player2.getStones().size());

        assertEquals(SIZE - (2 * DESK_SIZE), game.getBag().getStones().size());
    }
}
