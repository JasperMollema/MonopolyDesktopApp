package model;

import java.util.List;

public class MonopolyGame {
    private List<Player> playerList;

    public MonopolyGame(List<Player> playerList) {
        this.playerList = playerList;
        System.out.println("MONOPOLY GAME INITIALIZED");
        validatePlayerList();
        for (Player player : playerList) {
            System.out.println(player);
        }
    }

    private void validatePlayerList() {
        if (playerList == null) {
            throw new RuntimeException("Trying to create a monopoly game with no players, playerList is null");
        }

        if (playerList.size() < 2) {
            throw new RuntimeException("Trying to create a monopoly game with less than two players");
        }

        if (playerList.size() > 6) {
            throw new RuntimeException("Trying to create a monopoly game with more than six players");
        }
    }
}
