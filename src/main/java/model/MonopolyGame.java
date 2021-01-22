package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains all the data of the game and could be saved to or loaded from a file.
 */
public class MonopolyGame implements Serializable {
    private List<Player> players;
    private Player playerToMove;
    private Map<String, Integer> playerPositions;

    public List<Player> getPlayers() {
        return players;
    }

    public void startGame(List<Player> players) {
        this.players = players;
        playerToMove = players.get(0);
        playerPositions = new HashMap<>();
        putPlayersOnStart();
    }

    private void putPlayersOnStart() {
        for (Player player : players) {
            playerPositions.put(player.toString(), MonopolyBoardSpaces.SPACENR_START);
        }
    }
    public String getActivePlayer() {
        return playerToMove.toString();
    }

    public void moveActivePlayer(int diceTrow) {
        // TODO: Unit test!
        String player = playerPositions.keySet().stream()
                .filter(playerName -> playerName.equals(playerToMove.toString()))
                .findAny()
                .get();

        int newPosition = playerPositions.get(player) + diceTrow;
        if (newPosition > MonopolyBoardSpaces.SPACENR_KALVERSTRAAT) {
            newPosition = newPosition - MonopolyBoardSpaces.NR_OF_BOARDSPACES;
        }

        playerPositions.put(player, newPosition);
        int indexActivePlayer = players.indexOf(playerToMove);
        int indexNewActivePlayer = indexActivePlayer + 1;

        if (indexNewActivePlayer == players.size()) {
            indexNewActivePlayer = 0;
        }
        playerToMove = players.get(indexNewActivePlayer);
    }

    public Map<String, Integer> getPlayerPositions() {
        return playerPositions;
        // TODO: Maybe return a copy.
    }
}
