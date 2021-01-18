package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNameValidator {
    public static final int MIN_NR_OF_PLAYERS = 2;
    public static final int MAX_NR_OF_PLAYERS = 6;

    public static boolean validatePlayers(List<String> playerNames) {
        if (playerNames.size() < MIN_NR_OF_PLAYERS || playerNames.size() > MAX_NR_OF_PLAYERS) {
            return false;
        }

        if (playerNamesAreNotUnique(playerNames)) {
            return false;
        }
        return true;
    }

    private static boolean playerNamesAreNotUnique(List<String> playerNames) {
        Set<String> uniquePlayerNames = new HashSet<>();
        for (String playerName : playerNames) {
            if (!uniquePlayerNames.add(playerName)) {
                return true;
            }
        }
        return false;
    }
}
