package service;

import model.Player;

public class SelectNumberOfPlayersService extends Service {

    public void addPlayer(String name) {
        getMonopolyGame().addPlayer(new Player(name));
    }
}
