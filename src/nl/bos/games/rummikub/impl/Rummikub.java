package nl.bos.games.rummikub.impl;

import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IRummikub;

/**
 * Created by bosa on 11-7-2017.
 * Main class for the Rummikub game
 */
public class Rummikub implements IRummikub {
    private static final String ANTAL = "Antal";
    private static final String KIM = "Kim";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final int AGE_36 = 36;
    private static final int AGE_33 = 33;

    public static void main(String[] args) {
        //Init the game object
        //IRummikub game = new Rummikub();

        //List<IPlayer> players = new ArrayList<>();

        //Add player to the game
        IPlayer player1 = new Player(ANTAL, AGE_36, MALE);
        IPlayer player2 = new Player(KIM, AGE_33, FEMALE);
        //TODO game.addPlayer(player1);
        //TODO game.addPlayer(player2);

        //Init a scrambled bag with stones
        IBag bag = new Bag();
        bag.addStones();
        bag.scramble();
        bag.display();
        //TODO game.addBag(bag);

        //Pick stones
        player1.pickStones(bag);
        player2.pickStones(bag);

        player1.display();
        player1.displayDesk();
    }
}
