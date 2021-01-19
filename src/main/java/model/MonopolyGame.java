package model;

import java.io.Serializable;
import java.util.List;

/**
 * This class contains all the data of the game and could be saved to or loaded from a file.
 */
public class MonopolyGame implements Serializable {
    private List<Player> players;
    private Player playerToMove;

    public List<Player> getPlayers() {
        return players;
    }

    public void startGame(List<Player> players) {
        this.players = players;
        playerToMove = players.get(0);
    }
    public String getActivePlayer() {
        return playerToMove.toString();
    }
}
