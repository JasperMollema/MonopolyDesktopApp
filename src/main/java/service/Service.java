package service;

import model.MonopolyGame;

public class Service {
    private MonopolyGame monopolyGame;

    public MonopolyGame getMonopolyGame() {
        if (monopolyGame == null) {
            return new MonopolyGame();
        }
        return monopolyGame;
    }

    public void startNewMonopolyGame() {
        monopolyGame = new MonopolyGame();
    }
}
