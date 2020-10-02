package service;

import model.MonopolyGame;
import model.Player;

public class SelectNumberOfPlayersService extends Service {
    MonopolyGame monopolyGame;

    public void addPlayer(String name) {
        getMonopolyGame().addPlayer(new Player(name));
    }
}
