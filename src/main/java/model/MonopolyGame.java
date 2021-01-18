package model;

import java.io.Serializable;
import java.util.List;

/**
 * This class contains all the data of the game and could be saved to or loaded from a file.
 */
public class MonopolyGame implements Serializable {
    private List<Player> players;
    private Player playerToMove;

    public MonopolyGame(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
