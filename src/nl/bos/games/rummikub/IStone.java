package nl.bos.games.rummikub;

/**
 * Created by bosa on 11-7-2017.
 */
public interface IStone {
    enum COLOR {BLACK, RED, BLUE, YELLOW}
    int MAX_NUMBER = 13;

    int getValue();
    IStone.COLOR getColor();
}
