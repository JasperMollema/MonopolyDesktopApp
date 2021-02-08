package model;

import java.io.Serializable;
import java.util.Map;

/**
 * This class contains all the data of the game and could be saved to or loaded from a file.
 */
public class MonopolyGame implements Serializable {
    private Player[] players;
    private Player activePlayer;
    private Integer nrOfDiceThrowsActivePlayer;
    private Boolean canPlayerThrowAgain;
    private PlayerPositionMap playerPositions;

    public MonopolyGame() {}

    public void startGame(Player[] players) {
        playerPositions = new PlayerPositionMap();
        nrOfDiceThrowsActivePlayer = 0;
        canPlayerThrowAgain = Boolean.FALSE;
        this.players = players;
        putPlayersOnStart();
        activePlayer = players[0];
    }

    private void putPlayersOnStart() {
        for (Player player : players) {
            playerPositions.put(player, MonopolyBoardSpaces.SPACENR_START);
        }
    }

    public void movePlayer(DiceThrow diceThrow) {
        Integer newPosition = determineNewPosition(diceThrow);
        playerPositions.put(activePlayer, newPosition);
        nrOfDiceThrowsActivePlayer++;
        canPlayerThrowAgain = diceThrow.isDoubleThrow() && nrOfDiceThrowsActivePlayer < 3;
    }

    private Integer determineNewPosition(DiceThrow diceThrow) {
        int oldPosition = playerPositions.get(activePlayer);
        int totalThrow = diceThrow.getTotalThrow();

        int newPosition = oldPosition + totalThrow;
        if (newPosition > MonopolyBoardSpaces.SPACENR_KALVERSTRAAT) {
            newPosition = newPosition - MonopolyBoardSpaces.NR_OF_BOARDSPACES;
        }

        return newPosition;
    }

    public void endTurn() {
        int playerIndex = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] == activePlayer) {
                playerIndex = i;
            }
        }
        int newPlayerIndex = playerIndex + 1;
        if (newPlayerIndex == players.length) {
            newPlayerIndex = 0;
        }
        activePlayer = players[newPlayerIndex];
        nrOfDiceThrowsActivePlayer = 0;
        canPlayerThrowAgain = true;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void fillActivePlayer(String playerName) {
        if (players == null) {
            throw new RuntimeException("fillActivePlayer() There are no Players");
        }
        for (Player player : players) {
            if (player.toString().equals(playerName)) {
                activePlayer = player;
            }
        }
    }

    public Integer getNrOfDiceThrowsActivePlayer() {
        return nrOfDiceThrowsActivePlayer;
    }

    public void setNrOfDiceThrowsActivePlayer(Integer nrOfDiceThrowsActivePlayer) {
        this.nrOfDiceThrowsActivePlayer = nrOfDiceThrowsActivePlayer;
    }

    public Boolean canPlayerThrowAgain() {
        return canPlayerThrowAgain;
    }

    public void setCanPlayerThrowAgain(Boolean canPlayerThrowAgain) {
        this.canPlayerThrowAgain = canPlayerThrowAgain;
    }

    public Map<Player, Integer> getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(PlayerPositionMap playerPositions) {
        this.playerPositions = playerPositions;
    }
}
