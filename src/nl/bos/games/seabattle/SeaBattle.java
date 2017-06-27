package nl.bos.games.seabattle;

import java.awt.*;
import java.util.*;
import java.util.List;

import static nl.bos.games.seabattle.ISeaBattleConstants.*;

/**
 * A SeaBattle game class where it all starts
 */
public class SeaBattle {
    private final List<IShip> battleFleet = new ArrayList<>();
    private final char[][] battleField = new char[SIZE][SIZE];
    private int recursiveAction = 0;
    private int nrOfBombsAvailable = MAX_BOMBS;
    private int nrOfBoatHits = 0;

    public static void main(String[] args) {
        logMessage(String.format("Welcome to %s!", APP_TITLE));

        SeaBattle battle = new SeaBattle();
        battle.drawLogo();

        try {
            battle.initBattleField();
            battle.initTheFleet();
            battle.initBattleFieldWithShips();
        } catch (InitializationException ie) {
            logMessage(String.format("Exception in initializing the game with message: '%s'", ie.getMessage()), ERROR, true);
        }

        logMessage("Ready for attack...BOMBS AWAY!");
        battle.startShooting();
    }

    private static void logMessage(String message, int level, boolean doLineBreak) {
        if(doLineBreak)
            logMessage(message + "\n", level);
        else
            logMessage(message, level);
    }

    private static void logMessage(String message) {
        logMessage(message, INFO, true);
    }

    private static void logMessage(String message, int level) {
        switch (level) {
            case INFO:
                if(INFO <= LOG_LEVEL)
                    System.out.print(message);
                break;
            case ERROR:
                if(ERROR <= LOG_LEVEL)
                    System.out.print(message);
                break;
            case DEBUG:
                if(DEBUG <= LOG_LEVEL)
                    System.out.print(message);
                break;
            default:
                break;
        }
    }

    private void startShooting() {
        Scanner sc = new Scanner(System.in);
        boolean gameIsFinished = false;

        while (!gameIsFinished) {
            logMessage(SEPARATOR);
            logMessage("Give a coordinate to shoot on [eg. 0,0]; To stop type 'quit'.");
            drawBomb();
            logMessage(String.format("Available bombs [%s]: ", nrOfBombsAvailable), INFO, false);
            String input = sc.nextLine();

            if (input.equalsIgnoreCase(QUIT)) {
                gameIsFinished = true;
            }

            String[] position = input.split(",");
            try {
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                if (!(x >= 0 && x <= SIZE)) {
                    throw new NumberFormatException();
                }
                if (!(y >= 0 && y <= SIZE)) {
                    throw new NumberFormatException();
                }

                //Input is fine...continue
                logMessage(String.format("Target position to shoot = %s", Arrays.deepToString(position)), DEBUG, true);

                if (battleField[x][y] == BOAT) {
                    logMessage(HIT_MESSAGES[new Random().nextInt(HIT_MESSAGES.length)]);
                    updateFleetDetails(x, y);
                    battleField[x][y] = HIT;
                    nrOfBoatHits++;
                    printBattleField();
                } else if (battleField[x][y] == HIT) {
                    logMessage(ALREADY_HIT_MESSAGES[new Random().nextInt(ALREADY_HIT_MESSAGES.length)]);
                } else {
                    logMessage(MISSED_MESSAGES[new Random().nextInt(MISSED_MESSAGES.length)]);
                }

                nrOfBombsAvailable--;

                if(nrOfBombsAvailable < TOTAL_SHIP_SIZE-nrOfBoatHits) {
                    logMessage("Not enough bombs to win the game -> No use to continue!");
                    gameIsFinished = true;
                }
                if (nrOfBombsAvailable <= 0) {
                    if (nrOfBoatHits != TOTAL_SHIP_SIZE)
                        logMessage("Out of bombs...GAME OVER!");
                    gameIsFinished = true;
                }
                if (nrOfBoatHits == TOTAL_SHIP_SIZE) {
                    logMessage("You blast the thing!!...WE HAVE A WINNER!!");
                    gameIsFinished = true;
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException nfe) {
                if (!gameIsFinished)
                    logMessage("No valid input found!", ERROR, true);
            }
        }
    }

    private void updateFleetDetails(int x, int y) {
        for (IShip ship : battleFleet) {
            int index = 0;
            for (Point point : ship.getCoordinates()) {
                if (x == point.getX() && y == point.getY()) {
                    logMessage(String.format("Cleaning point [%s, %s] for the '%s' ship", x, y, ship.getType()), DEBUG, true);
                    ship.removeCoordinate(index);
                    if (shipIsDestroyed(ship)) {
                        logMessage(String.format("Ship '%s' is totally gone....good work!!", ship.getType()));
                    }
                }
                index++;
            }
        }
    }

    private boolean shipIsDestroyed(IShip ship) {
        boolean result = false;

        int index = 0;
        for (Point point : ship.getCoordinates()) {
            if (point.getX() != -1 && point.getY() != -1) {
                return false;
            }
            index++;
            if (index == ship.getSize())
                result = true;
        }
        return result;
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

        IShip destroyer = new Ship(DESTROYER, SIZE_DESTROYER, random.nextBoolean());
        battleFleet.add(destroyer);
        IShip submarine = new Ship(SUBMARINE, SIZE_SUBMARINE, random.nextBoolean());
        battleFleet.add(submarine);
        IShip cruiser = new Ship(CRUISER, SIZE_CRUISER, random.nextBoolean());
        battleFleet.add(cruiser);
        IShip battleship = new Ship(BATTLESHIP, SIZE_BATTLESHIP, random.nextBoolean());
        battleFleet.add(battleship);
        IShip carrier = new Ship(CARRIER, SIZE_CARRIER, random.nextBoolean());
        battleFleet.add(carrier);
    }

    private void initBattleFieldWithShips() throws InitializationException {
        logMessage("Initialization of the battlefield with boats...");

        for (IShip ship : battleFleet) {
            addShipToBattleField(ship);
        }
        printBattleField();
    }

    private void printBattleField() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                logMessage(battleField[y][x] + " ", DEBUG, false);
            }
            logMessage("", DEBUG, true);
        }
    }

    private void addShipToBattleField(IShip ship) throws InitializationException {
        logMessage("", DEBUG, true);
        logMessage(SEPARATOR, DEBUG, true);
        logMessage(String.format("Add '%s' ship [Size %s] to the battlefield", ship.getType(), ship.getSize()), DEBUG, true);
        logMessage(SEPARATOR, DEBUG, true);
        logMessage(String.format("recursiveAction: %s", recursiveAction), DEBUG, true);

        Point coordinate = new Point();
        int shipSize = ship.getSize();
        boolean shipIsHorizontal = ship.isHorizontal();

        Random random = new Random();
        if (shipIsHorizontal) {
            coordinate.setLocation(random.nextInt(SIZE - shipSize), random.nextInt(SIZE));
            if (locationIsFree((int) coordinate.getX(), (int) coordinate.getY(), shipSize, true)) {
                ship.setInBattle(true);
                int index = 0;
                for (int i = (int) coordinate.getX(); i < (int) coordinate.getX() + shipSize; i++) {
                    battleField[i][(int) coordinate.getY()] = BOAT;
                    ship.addCoordinate(i, (int) coordinate.getY(), index);
                    index++;
                }
                String[] position = {Integer.toString((int) coordinate.getX()), Integer.toString((int) coordinate.getY())};
                logMessage(String.format("Location %s -> Size: %s, Horizontal", Arrays.deepToString(position), shipSize), DEBUG, true);
                recursiveAction = 0;
            } else {
                recursiveAction++;
                if (recursiveAction == MAX_RECURSIVE_TRIES) {
                    throw new InitializationException("To many recursive tries for adding the same boat!");
                } else {
                    ship.setInBattle(false);
                    addShipToBattleField(ship);
                }
            }
        } else {
            coordinate.setLocation(random.nextInt(SIZE), random.nextInt(SIZE - shipSize));
            if (locationIsFree((int) coordinate.getX(), (int) coordinate.getY(), shipSize, false)) {
                ship.setInBattle(true);
                int index = 0;
                for (int i = (int) coordinate.getY(); i < (int) coordinate.getY() + shipSize; i++) {
                    battleField[(int) coordinate.getX()][i] = BOAT;
                    ship.addCoordinate((int) coordinate.getX(), i, index);
                    index++;
                }
                String[] position = {Integer.toString((int) coordinate.getX()), Integer.toString((int) coordinate.getY())};
            logMessage(String.format("Location %s -> Size: %s, Vertical", Arrays.deepToString(position), shipSize), DEBUG, true);
            recursiveAction = 0;
            } else {
                recursiveAction++;
                if (recursiveAction == MAX_RECURSIVE_TRIES) {
                    throw new InitializationException("Boat can't be placed [too many recursive tries]!");
                } else
                    ship.setInBattle(false);
                addShipToBattleField(ship);
            }
        }
    }

    private boolean locationIsFree(int x, int y, int size, boolean isHorizontal) {
        boolean result = true;

        if (isHorizontal) {
            for (int i = x; i < x + size; i++) {
                if (battleField[i][y] == BOAT) {
                    result = false;
                    logMessage(String.format("Boat found on location [%s, %s]", i, y), DEBUG, true);
                    break;
                }
            }
        } else {
            for (int i = y; i < y + size; i++) {
                if (battleField[x][i] == BOAT) {
                    result = false;
                    logMessage(String.format("Boat found on location [%s, %s]", i, y), DEBUG, true);
                    break;
                }
            }
        }
        return result;
    }

    private void drawBomb() {
        logMessage("        ,--.!,");
        logMessage("     __/   -*-");
        logMessage("   ,d08b.  '|`");
        logMessage("   0088MM     ");
        logMessage("   `9MMP'     ");
    }

    private void drawLogo() {
        logMessage("      _~  _~");
        logMessage("   __|=|_|=|__");
        logMessage("   \\ o.o.o.o /");
        logMessage("    \\_______/");
        logMessage("  ~~~~~~~~~~~~~~");
    }
}