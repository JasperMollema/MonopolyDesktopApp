package services;

import exceptions.BadNameException;
import exceptions.EmptyNameException;
import exceptions.IdenticalNameException;
import model.Player;
import settings.Settings;

import java.util.ArrayList;
import java.util.List;

import static exceptions.BadNameException.BadNameType.EMPTY_NAME;
import static exceptions.BadNameException.BadNameType.IDENTICAL_NAME;

public class SelectNumberOfPlayersService {
    private List<Player> playerList;

    public SelectNumberOfPlayersService() {
        playerList = new ArrayList<>();
    }

    public void addPlayer(String name) throws BadNameException {
        Player player = new Player(name);
        validateAddedPlayer(player, name);
        playerList.add(new Player(name));
    }

    private void validateAddedPlayer(Player player, String name) throws BadNameException {
        if (playerList.contains(player)) {
            playerList.clear();
            throw new IdenticalNameException(IDENTICAL_NAME);
        }

        if (name == null || name.isBlank()) {
            playerList.clear();
            throw new EmptyNameException(EMPTY_NAME);
        }

        if (name.length() > Settings.MAX_LENGTH_PLAYER_NAME) {
            playerList.clear();
            throw new RuntimeException("Name is too long.");
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
