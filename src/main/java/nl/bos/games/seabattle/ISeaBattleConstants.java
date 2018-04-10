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
    String QUIT = "quit";

    int MAX_RECURSIVE_TRIES = 100;
    int TOTAL_SHIP_SIZE = SIZE_DESTROYER + SIZE_SUBMARINE + SIZE_CRUISER + SIZE_BATTLESHIP + SIZE_CARRIER;
    int MAX_BOMBS = TOTAL_SHIP_SIZE + 33;

    int INFO = 1;
    int ERROR = 2;
    int DEBUG = 3;

    String[] HIT_MESSAGES = {
            "BOMBS AWAY!!......Brrrrrhrhhhhaaaaa....You've got a HIT",
            "You bombed it....WhooHaa...HIT me baby!",
            "Hell yeahhhh...HIT HIT HIT",
            "Go Bro....HIT me again if you can",
            "HIT....You're the best!"
    };

    String[] ALREADY_HIT_MESSAGES = {
            "You stupid f@#!...It's already cleaned with a hit -> bomb is gone!",
            "Man, what do you not understand when i say to 'hit' me?",
            "Just through it away...How will you ever win like this",
            "Ok, do i need to do it all be myself?",
            "What is wrong with your memory!?"
    };

    String[] MISSED_MESSAGES = {
            "You poor basterd...Next time hit better -> bomb is gone!",
            "Try again...bomb is gone",
            "The world is 80% water....A MISS!",
            "No boat found here...Try again!",
            "Man, where are those boats...Are they even in the field!?"
    };
}