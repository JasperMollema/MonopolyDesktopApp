package service;

import model.MonopolyGame;

public class Service {
    private static MonopolyGame monopolyGame;

    public MonopolyGame getMonopolyGame() {
        if (monopolyGame == null) {
            return new MonopolyGame();
        }
        return monopolyGame;
    }
}
