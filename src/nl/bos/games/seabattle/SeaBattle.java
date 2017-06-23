/**
 * Created by bosa on 22-6-2017.
 */
package nl.bos.games.seabattle;

import java.awt.*;
import java.util.*;
import java.util.List;

import static nl.bos.games.seabattle.ISeaBattleContants.*;

//TODO Add some random text
//TODO Add start a logo
//TODO Add bomb a logo
//TODO Add some delay animation

public class SeaBattle {
    private List<IShip> battleFleet = new ArrayList<IShip>();
    private IShip destroyer, submarine, cruiser, battleship, carrier;
    private char[][] battleField = new char[SIZE][SIZE];
    private int recursiveAction = 0;
    private int nrOfBombsAvailable = MAX_BOMBS;
    private int nrOfBoatHits = 0;

    public static void main(String[] args) {
        System.out.println(String.format("Welcome to %s!", APP_TITLE));

        SeaBattle battle = new SeaBattle();

        try {
            battle.initBattleField();
            battle.initTheFleet();
            battle.initBattleFieldWithShips();
        } catch (InitializationException ie) {
            System.out.println(String.format("Exception in initializing the game with message: '%s'", ie.getMessage()));
        }

        System.out.println("Ready for attack...BOMBS AWAY!");
        battle.startShooting();
    }

    private void startShooting() {
        Scanner sc = new Scanner(System.in);
        boolean gameIsFinished = false;

        while (!gameIsFinished) {
            System.out.println(SEPERATOR);
            System.out.println(String.format("Give a coordinate to shoot on [eg. 0,0]; Available bombs [%s]:", nrOfBombsAvailable));
            String input = sc.nextLine();
            String[] position = input.split(",");
            try {
                int x = Integer.parseInt(position[1]);
                int y = Integer.parseInt(position[0]);
                if (!(x >= 0 && x <= SIZE)) {
                    throw new NumberFormatException();
                }
                if (!(y >= 0 && y <= SIZE)) {
                    throw new NumberFormatException();
                }

                //Input is fine...continue
                nrOfBombsAvailable--;
                if (isDebugMode)
                    System.out.println(String.format("Target position to shoot = %s", Arrays.deepToString(position)));

                if (battleField[x][y] == BOAT) {
                    System.out.println("BOMBS AWAY!!......Brrrrrhrhhhhaaaaa....You've got a HIT");
                    battleField[x][y] = HIT;
                    nrOfBoatHits++;
                    if(isDebugMode) {
                        for (char row[] : battleField) {
                            System.out.println(Arrays.deepToString(new String(row).split("(?!^)")));
                        }
                    }
                } else if (battleField[x][y] == HIT) {
                    System.out.println("You stupid f@#!...It's already cleaned with a hit -> bomb is gone!");
                } else {
                    System.out.println("You poor bastered...Next time hit better -> bomb is gone!");
                }
                if (nrOfBombsAvailable <= 0) {
                    System.out.println("Out of bombs...GAME OVER!");
                    gameIsFinished = true;
                }
                if (nrOfBoatHits == TOTAL_SHIP_SIZE) {
                    System.out.println("You blast the thing!!...WE HAVE A WINNER!!");
                    gameIsFinished = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("No valid input found!");
            }
        }
    }

    private void initBattleField() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                battleField[x][y] = WATER;
            }
        }
    }

    private void initTheFleet() {
        Random random = new Random();

        destroyer = new Ship(DESTROYER, SIZE_DESTROYER, random.nextBoolean());
        battleFleet.add(destroyer);
        submarine = new Ship(SUBMARINE, SIZE_SUBMARINE, random.nextBoolean());
        battleFleet.add(submarine);
        cruiser = new Ship(CRUISER, SIZE_CRUISER, random.nextBoolean());
        battleFleet.add(cruiser);
        battleship = new Ship(BATTLESHIP, SIZE_BATTLESHIP, random.nextBoolean());
        battleFleet.add(battleship);
        carrier = new Ship(CARRIER, SIZE_CARRIER, random.nextBoolean());
        battleFleet.add(carrier);
    }

    private void initBattleFieldWithShips() throws InitializationException {
        System.out.println("Initialization of the battlefield with boats...");

        for (IShip ship : battleFleet) {
            Point position = addShipToBattleField(ship);
            ship.setLocationX((int) position.getX());
            ship.setLocationY((int) position.getY());
            ship.setInBattle(true);
        }
        if(isDebugMode) {
            for (char row[] : battleField) {
                System.out.println(Arrays.deepToString(new String(row).split("(?!^)")));
            }
        }
    }

    private Point addShipToBattleField(IShip ship) throws InitializationException {
        if (isDebugMode) {
            System.out.println();
            System.out.println(SEPERATOR);
            System.out.println(String.format("Add '%s' ship to the battlebuild", ship.getType()));
            System.out.println(SEPERATOR);
            System.out.println(String.format("recursiveAction: %s", recursiveAction));
        }

        Point result = new Point();
        int shipSize = ship.getSize();
        boolean shipIsHorizontal = ship.isHorizontal();

        Random random = new Random();
        if (shipIsHorizontal) {
            result.setLocation(random.nextInt(SIZE - shipSize), random.nextInt(SIZE));
            if (locationIsFree((int) result.getX(), (int) result.getY(), shipSize, shipIsHorizontal)) {
                for (int i = (int) result.getX(); i < (int) result.getX() + shipSize; i++) {
                    battleField[(int) result.getY()][i] = BOAT;
                }
                String[] position = {Integer.toString((int) result.getX()), Integer.toString((int) result.getY())};
                if (isDebugMode)
                    System.out.println(String.format("Location %s -> Size: %s, Horizontal", Arrays.deepToString(position), shipSize));
                recursiveAction = 0;
            } else {
                recursiveAction++;
                if (recursiveAction == MAX_RECURSIVE_TRIES) {
                    throw new InitializationException("To many recursive tries for adding the same boat!");
                } else
                    addShipToBattleField(ship);
            }
        } else {
            result.setLocation(random.nextInt(SIZE), random.nextInt(SIZE - shipSize));
            if (locationIsFree((int) result.getY(), (int) result.getX(), shipSize, shipIsHorizontal)) {
                for (int i = (int) result.getY(); i < (int) result.getY() + shipSize; i++) {
                    battleField[i][(int) result.getX()] = BOAT;
                }
                String[] position = {Integer.toString((int) result.getX()), Integer.toString((int) result.getY())};
                if (isDebugMode)
                    System.out.println(String.format("Location %s -> Size: %s, Vertical", Arrays.deepToString(position), shipSize));
                recursiveAction = 0;
            } else {
                recursiveAction++;
                if (recursiveAction == MAX_RECURSIVE_TRIES) {
                    throw new InitializationException("Boat can't be placed [to0 many recursive tries]!");
                } else
                    addShipToBattleField(ship);
            }
        }

        return result;
    }

    private boolean locationIsFree(int position, int location, int size, boolean isHorizontal) {
        boolean result = true;

        for (int i = position; i < position + size; i++) {
            if (isHorizontal) {
                if (battleField[location][i] == BOAT) {
                    result = false;
                    if (isDebugMode)
                        System.out.println(String.format("Horizontal boat found for [%s, %s, %s]", position, location, size));
                    break;
                }
            } else {
                if (battleField[i][location] == BOAT) {
                    result = false;
                    if (isDebugMode)
                        System.out.println(String.format("Vertical boat found for [%s, %s, %s]", position, location, size));
                    break;
                }
            }
        }
        return result;
    }
}