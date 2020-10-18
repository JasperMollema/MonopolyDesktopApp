package services;

import exceptions.BadNameException;
import exceptions.EmptyNameException;
import exceptions.IdenticalNameException;
import settings.Settings;

import java.util.ArrayList;
import java.util.List;

import static exceptions.BadNameException.BadNameType.EMPTY_NAME;
import static exceptions.BadNameException.BadNameType.IDENTICAL_NAME;

public class SelectNumberOfPlayersService {
    private List<String> playerNamesList;

    public SelectNumberOfPlayersService() {
        playerNamesList = new ArrayList<>();
    }

    public void addPlayerName(String name) throws BadNameException {
        validateAddedPlayerName(name);
        playerNamesList.add(name);
    }

    private void validateAddedPlayerName(String name) throws BadNameException {
        if (playerNamesList.contains(name)) {
            playerNamesList.clear();
            throw new IdenticalNameException(IDENTICAL_NAME);
        }

        if (name == null || name.isBlank()) {
            playerNamesList.clear();
            throw new EmptyNameException(EMPTY_NAME);
        }

        if (name.length() > Settings.MAX_LENGTH_PLAYER_NAME) {
            playerNamesList.clear();
            throw new RuntimeException("Name is too long.");
        }
    }

    public List<String> getPlayerNamesList() {
        return playerNamesList;
    }
}
