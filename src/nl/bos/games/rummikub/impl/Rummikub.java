package nl.bos.games.rummikub.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IRummikub;
import nl.bos.games.rummikub.IStone;

import java.util.*;

/**
 * Created by bosa on 11-7-2017.
 * Main class for the Rummikub game
 */
@Log
public class Rummikub implements IRummikub {
    private static final String MSG_INPUT = "What to play: (q)uit | (p)ick | (c)hoice?";
    private static final String MSG_QUIT = "Quit the game!";
    private static final String MSG_CHOICE = "Make a choice of stones to play from your desk (comma separated):";
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
    @Getter
    @Setter
    private IBag gameBag = new Bag();
    private static final IRummikub GAME = new Rummikub();

    public static void main(String[] args) {
        //Init the game object
        IBag bag = new Bag();

        //Add player to the game
        IPlayer player1 = new Player(ANTAL, AGE_36, MALE);
        IPlayer player2 = new Player(KIM, AGE_33, FEMALE);
        GAME.addPlayer(player1);
        GAME.addPlayer(player2);

        //Init a scrambled bag with stones
        bag.addStones();
        bag.scramble();
        bag.display();
        GAME.setGameBag(bag);

        //Pick stones
        player1.pickStones(bag);
        player2.pickStones(bag);

        GAME.getGamePlayers().get(0).display();
        GAME.getGamePlayers().get(0).displayDesk();

        while (!gameOver) {
            if(readUserInput())
                doAI(GAME.getGamePlayers().get(1));
        }
    }

    private static boolean readUserInput() {
        IPlayer player1 = GAME.getGamePlayers().get(0);

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
                player1.pickStone(GAME.getGameBag());
                player1.displayDesk();
                lomlog.info(String.format("Stones in bag: %s", GAME.getGameBag().getStones().size()));
                break;
            case C:
                lomlog.info(MSG_CHOICE);
                String stoneInput = input.nextLine();
                String[] stones = stoneInput.split(",");
                int[] stoneChoices = new int[stones.length];

                int index = 0;
                for (String stone : stones) {
                    try {
                        stoneChoices[index++] = Integer.parseInt(stone);
                    } catch (NumberFormatException nfe) {
                        lomlog.info(MSG_INVALID);
                        return false;
                    }
                }
                List<IStone> stonesToPlay = createStonesSet(stoneChoices, player1.getStones());
                if(stonesToPlay.size() == stoneChoices.length) {
                    lomlog.fine(String.format("Chosen stones: %s", Arrays.toString(stoneChoices)));
                    if(isValidStonesSet(stonesToPlay)) {
                        moveStonesFromPlayerDeskToTable();
                    } else
                        return false;
                } else
                    return false;
                break;
            default:
                lomlog.info(MSG_INVALID);
                break;
        }
        return true;
    }

    private static List<IStone> createStonesSet(int[] stoneChoices, List<IStone> stones) {
        List<IStone> result = new ArrayList<>();
        for (int choice: stoneChoices) {
            try {
                result.add(stones.get(choice));
            } catch(IndexOutOfBoundsException ioobe) {
                lomlog.info(MSG_INVALID);
                break;
            }
        }
        return result;
    }
    
    private static void moveStonesFromPlayerDeskToTable() {
        //TODO
    }

    private static boolean isValidStonesSet(List<IStone> stonesToPlay) {
        boolean result = false;

        //TODO Check if minimal 3 stones are selected; If so check if colors are equal and numbers are in range; Or if numbers are the same and colors are different.

        return result;
    }

    private static void doAI(IPlayer player) {
        player.display();
        //TODO
    }

    @Override
    public void addPlayer(IPlayer player) {
        gamePlayers.add(player);
    }
}
