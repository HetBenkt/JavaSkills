package nl.bos.games.rummikub;

import java.util.List;

/**
 * Created by bosa on 21-7-2017.
 * Interface for the Rummikub object
 */
public interface IRummikub {

    void addPlayer(IPlayer player1);
    List<IPlayer> getGamePlayers();
    void setGameBag(IBag bag);
}
