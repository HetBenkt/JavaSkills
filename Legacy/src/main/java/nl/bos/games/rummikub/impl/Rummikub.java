package nl.bos.games.rummikub.impl;

import nl.bos.games.rummikub.IBag;
import nl.bos.games.rummikub.IPlayer;
import nl.bos.games.rummikub.IRummikub;
import nl.bos.games.rummikub.IStone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bosa on 11-7-2017.
 * Main class for the Rummikub game
 */
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

    private List<IPlayer> gamePlayers = new ArrayList<>();
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
        System.out.println(MSG_INPUT);
        String selection = input.nextLine();
        switch (selection.charAt(0)) {
            case Q:
                System.out.println(MSG_QUIT);
                gameOver = true;
                break;
            case P:
                System.out.println(MSG_PICK);
                player1.pickStone(GAME.getGameBag());
                player1.displayDesk();
                System.out.println(String.format("Stones in bag: %s", GAME.getGameBag().getStones().size()));
                break;
            case C:
                System.out.println(MSG_CHOICE);
                String stoneInput = input.nextLine();
                String[] stones = stoneInput.split(",");
                int[] stoneChoices = new int[stones.length];

                int index = 0;
                for (String stone : stones) {
                    try {
                        stoneChoices[index++] = Integer.parseInt(stone);
                    } catch (NumberFormatException nfe) {
                        System.out.println(MSG_INVALID);
                        return false;
                    }
                }
                List<IStone> stonesToPlay = createStonesSet(stoneChoices, player1.getStones());
                if(stonesToPlay.size() == stoneChoices.length) {
                    System.out.println(String.format("Chosen stones: %s", Arrays.toString(stoneChoices)));
                    if(isValidStonesSet(stonesToPlay)) {
                        moveStonesFromPlayerDeskToTable();
                    } else
                        return false;
                } else
                    return false;
                break;
            default:
                System.out.println(MSG_INVALID);
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
                System.out.println(MSG_INVALID);
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

    public static String getMsgInput() {
        return MSG_INPUT;
    }

    public static String getMsgQuit() {
        return MSG_QUIT;
    }

    public static String getMsgChoice() {
        return MSG_CHOICE;
    }

    public static String getMsgPick() {
        return MSG_PICK;
    }

    public static String getMsgInvalid() {
        return MSG_INVALID;
    }

    public static char getQ() {
        return Q;
    }

    public static char getP() {
        return P;
    }

    public static char getC() {
        return C;
    }

    public static String getANTAL() {
        return ANTAL;
    }

    public static String getKIM() {
        return KIM;
    }

    public static String getMALE() {
        return MALE;
    }

    public static String getFEMALE() {
        return FEMALE;
    }

    public static int getAge36() {
        return AGE_36;
    }

    public static int getAge33() {
        return AGE_33;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Rummikub.gameOver = gameOver;
    }

    public static IRummikub getGAME() {
        return GAME;
    }

    @Override
    public List<IPlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(List<IPlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    @Override
    public IBag getGameBag() {
        return gameBag;
    }

    @Override
    public void setGameBag(IBag gameBag) {
        this.gameBag = gameBag;
    }
}
