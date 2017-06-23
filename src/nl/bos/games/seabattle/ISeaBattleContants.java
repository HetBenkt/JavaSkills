package nl.bos.games.seabattle;

/**
 * Created by bosa on 23-6-2017.
 */
public interface ISeaBattleContants {
    public static final char WATER = '~';
    public static final char BOAT = 'B';

    public static final String STR_DESTROYER = "Destroyer";
    public static final String STR_SUBMARINE = "Submarine";
    public static final String STR_CRUISER = "Cruiser";
    public static final String STR_BATTLESHIP = "Battleship";
    public static final String STR_CARRIER = "Carrier";

    public static final int SIZE_DESTROYER = 2;
    public static final int SIZE_SUBMARINE = 3;
    public static final int SIZE_CRUISER = 3;
    public static final int SIZE_BATTLESHIP = 4;
    public static final int SIZE_CARRIER = 5;

    public static final int SIZE = 10;
    public static final String APP_TITLE = "Seaship battle";
    public static final String SEPERATOR = "===============================================";

    public static final int MAX_RECURSIVE_TRIES = 100;

    public static final boolean isDebugMode = false;
}
