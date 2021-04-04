package services;

import exceptions.BadNameException;
import exceptions.EmptyNameException;
import exceptions.IdenticalNameException;
import settings.Settings;
import valueObjects.PlayerValueObject;

import java.util.ArrayList;
import java.util.List;

import static exceptions.BadNameException.BadNameType.EMPTY_NAME;
import static exceptions.BadNameException.BadNameType.IDENTICAL_NAME;

public class PlayersSetupService {
    private List<PlayerValueObject> players;

    public PlayersSetupService() {
        players = new ArrayList<>();
    }

    public void addPlayer(PlayerValueObject playerValueObject) throws BadNameException {
        validateAddedPlayerName(playerValueObject.name);
        players.add(playerValueObject);
    }

    private void validateAddedPlayerName(String name) throws BadNameException {
        if (players.contains(name)) {
            players.clear();
            throw new IdenticalNameException(IDENTICAL_NAME);
        }

        if (name == null || name.isBlank()) {
            players.clear();
            throw new EmptyNameException(EMPTY_NAME);
        }

        if (name.length() > Settings.MAX_LENGTH_PLAYER_NAME) {
            players.clear();
            throw new RuntimeException("Name is too long.");
        }
    }

    public List<PlayerValueObject> getPlayers() {
        return players;
    }
}
