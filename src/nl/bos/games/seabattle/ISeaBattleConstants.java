package nl.bos.games.seabattle;

/**
 * A constants interface for keeping the constants separated
 */
interface ISeaBattleConstants {
    char WATER = '~';
    char BOAT = 'B';
    char HIT = 'X';

    String DESTROYER = "Destroyer";
    String SUBMARINE = "Submarine";
    String CRUISER = "Cruiser";
    String BATTLESHIP = "Battleship";
    String CARRIER = "Carrier";

    int SIZE_DESTROYER = 2;
    int SIZE_SUBMARINE = 3;
    int SIZE_CRUISER = 3;
    int SIZE_BATTLESHIP = 4;
    int SIZE_CARRIER = 5;

    int SIZE = 10;
    String APP_TITLE = "Seaship battle";
    String SEPARATOR = "===============================================";

    int MAX_RECURSIVE_TRIES = 100;
    int TOTAL_SHIP_SIZE = SIZE_DESTROYER + SIZE_SUBMARINE + SIZE_CRUISER + SIZE_BATTLESHIP + SIZE_CARRIER;
    int MAX_BOMBS = TOTAL_SHIP_SIZE + 6;

    boolean isDebugMode = true;
}
