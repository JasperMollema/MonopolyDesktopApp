package services;

import exceptions.BadNameException;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class SelectNumberOfPlayersService {
    private List<Player> playerList;

    public SelectNumberOfPlayersService() {
        playerList = new ArrayList<>();
    }

    public void addPlayer(String name) throws BadNameException {
        Player player = new Player(name);
        if (playerList.contains(player)) {
            throw new BadNameException();
        }
        playerList.add(new Player(name));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
