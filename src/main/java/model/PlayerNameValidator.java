package model;

import valueObjects.PlayerValueObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNameValidator {
    public static final int MIN_NR_OF_PLAYERS = 2;
    public static final int MAX_NR_OF_PLAYERS = 6;

    public static boolean validatePlayers(List<PlayerValueObject> players) {
        if (players.size() < MIN_NR_OF_PLAYERS || players.size() > MAX_NR_OF_PLAYERS) {
            return false;
        }


        if (playerNamesAreNotUnique(players)) {
            return false;
        }
        return true;
    }

    private static boolean playerNamesAreNotUnique(List<PlayerValueObject> players) {
        Set<String> uniquePlayerNames = new HashSet<>();
        for (PlayerValueObject player : players) {
            if (!uniquePlayerNames.add(player.name)) {
                return true;
            }
        }
        return false;
    }
}
