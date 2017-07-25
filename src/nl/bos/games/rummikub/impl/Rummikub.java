package nl.bos.games.rummikub.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IRummikub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bosa on 11-7-2017.
 * Main class for the Rummikub game
 */
@Log
public class Rummikub implements IRummikub {
    private static final String MSG_INPUT = "What to play: (q)uit | (p)ick | (c)hoice?";
    private static final String MSG_QUIT = "Quit the game!";
    private static final String MSG_CHOICE = "Make a choice of stones to play from your desk";
    private static final String MSG_PICK = "Pick a new stone.";
    private static final String MSG_INVALID = "No valid input given!";

    private static final char Q = 'q';
    private static final char P = 'p';
    private static final char C = 'c';

    private static final String ANTAL = "Antal";
    private static final String KIM = "Kim";
    private static final String MALE = "male";
    private static final String FEMALE = "female";

    private static final int AGE_36 = 36;
    private static final int AGE_33 = 33;

    private static boolean gameOver = false;

    @Getter
    private List<IPlayer> gamePlayers = new ArrayList<>();
    @Setter
    private IBag gameBag = new Bag();

    public static void main(String[] args) {
        //Init the game object
        IRummikub game = new Rummikub();
        IBag bag = new Bag();

        //Add player to the game
        IPlayer player1 = new Player(ANTAL, AGE_36, MALE);
        IPlayer player2 = new Player(KIM, AGE_33, FEMALE);
        game.addPlayer(player1);
        game.addPlayer(player2);

        //Init a scrambled bag with stones
        bag.addStones();
        bag.scramble();
        bag.display();
        game.setGameBag(bag);

        //Pick stones
        player1.pickStones(bag);
        player2.pickStones(bag);

        game.getGamePlayers().get(0).display();
        game.getGamePlayers().get(0).displayDesk();

        readUserInput();
    }

    private static void readUserInput() {
        while(!gameOver) {
            Scanner input = new Scanner(System.in);
            lomlog.info(MSG_INPUT);
            String selection = input.nextLine();
            switch (selection.charAt(0)) {
                case Q:
                    lomlog.info(MSG_QUIT);
                    gameOver = true;
                    break;
                case P:
                    lomlog.info(MSG_PICK);
                    //TODO Pick a stone from the bag
                    break;
                case C:
                    lomlog.info(MSG_CHOICE);
                    //TODO Do the stone selection to play
                    break;
                default:
                    lomlog.info(MSG_INVALID);
                    break;
            }
        }
    }

    @Override
    public void addPlayer(IPlayer player) {
        gamePlayers.add(player);
    }
}
