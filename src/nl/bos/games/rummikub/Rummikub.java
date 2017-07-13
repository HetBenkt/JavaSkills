package nl.bos.games.rummikub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 * Main class for the Rummikub game
 */
public class Rummikub {
    private final List<IPlayer> players = new ArrayList<>();
    private IBag bag;

    public void addPlayer(IPlayer player) {
        players.add(player);
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    public void addBagOfStones(IBag bag) {
        this.bag = bag;
    }

    public IBag getBag() {
        return bag;
    }
}
