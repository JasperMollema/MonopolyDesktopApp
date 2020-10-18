package services;

import model.MonopolyGame;

import java.util.List;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;

    public void startMonopolyGame(List<String> playerNames) {
        monopolyGame = new MonopolyGame(playerNames);
    }
}
