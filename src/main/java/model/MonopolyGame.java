package model;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
    private List<Player> playerList;

    public MonopolyGame() {
        System.out.println("MONOPOLY GAME INITIALIZED");
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
        System.out.println("MonopolyGame addPlayer(): Added player : " + player);
    }
}
