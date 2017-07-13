package nl.bos.games.rummikub.tests;

import nl.bos.games.rummikub.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bosa on 11-7-2017.
 * The Main test class for TDD on the game implementation
 */
public class TestRummikub {
    private static final String ANTAL = "Antal";
    private static final String KIM = "Kim";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final int AGE_36 = 36;
    private static final int AGE_33 = 33;
    private static final int SIZE = 106;

    private static Rummikub game;
    private static IPlayer player1;
    private static IPlayer player2;
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

        assertEquals(testPlayer1.getName(), players.get(0).getName());
        assertEquals(testPlayer2.getName(), players.get(1).getName());
        assertEquals(testPlayer1.getAge(), players.get(0).getAge());
        assertEquals(testPlayer2.getAge(), players.get(1).getAge());
        assertEquals(testPlayer1.getGender(), players.get(0).getGender());
        assertEquals(testPlayer2.getGender(), players.get(1).getGender());
    }

    @Test
    public void testBagInitialization() {
        List<IStone> stones = game.getBag().getStones();

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
        player1.pickStones(bag);
        player1.display();
        player1.displayDesk();
        assertEquals(Player.DESK_SIZE, player1.getStones().size());

        player2.pickStones(bag);
        player2.display();
        player2.displayDesk();
        assertEquals(Player.DESK_SIZE, player2.getStones().size());

        assertEquals(SIZE - (2 * Player.DESK_SIZE), game.getBag().getStones().size());
    }
}
