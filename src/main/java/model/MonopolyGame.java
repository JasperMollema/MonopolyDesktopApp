package model;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
    private List<Player> players;

    public MonopolyGame(List<String> playerNames) {
        players = new ArrayList<>();

        validatePlayerNamesList(playerNames);
        createPlayers(playerNames);
        System.out.println("MONOPOLY GAME INITIALIZED");

        for (Player player : players) {
            System.out.println(player);
        }
    }

    private void validatePlayerNamesList(List<String> playerNames) {
        if (playerNames == null) {
            throw new RuntimeException("Trying to create a monopoly game with no players, playerList is null");
        }

        if (playerNames.size() < 2) {
            throw new RuntimeException("Trying to create a monopoly game with less than two players");
        }

        if (playerNames.size() > 6) {
            throw new RuntimeException("Trying to create a monopoly game with more than six players");
        }
    }

    private void createPlayers(List<String> playerNames) {
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
