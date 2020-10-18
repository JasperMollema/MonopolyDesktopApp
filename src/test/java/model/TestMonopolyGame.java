package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMonopolyGame {
    private final String NAME_1 = "name1";
    private final String NAME_2 = "name2";
    private final String NAME_3 = "name3";
    private List<String> playerNames = Arrays.asList(new String[]{NAME_1, NAME_2, NAME_3});

    @Test
    void gameShouldNotHaveMoreThanSixPlayers() {
        assertThrows(RuntimeException.class, () -> new MonopolyGame(createListWithSevenPlayerNames()));
    }

    private List<String> createListWithSevenPlayerNames() {
        List<String> playerNames = new ArrayList<>();
        String name = "name";
        for (int i = 0; i < 7; i++) {
            playerNames.add(name + i);
        }
        return playerNames;
    }

    @Test
    void gameShouldHaveMinimalTwoPlayers() {
        assertThrows(RuntimeException.class, () -> new MonopolyGame(createListWithOnePlayerName()));
        assertThrows(RuntimeException.class, () -> new MonopolyGame(null));
        assertThrows(RuntimeException.class, () -> new MonopolyGame(new ArrayList<>()));
    }

    private List<String> createListWithOnePlayerName() {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("name");
        return playerNames;
    }

    @Test
    void playerNamesShouldMatchNamesActualPlayers() {
        MonopolyGame monopolyGame = new MonopolyGame(playerNames);
        List<String> actualPlayerNames = getNamesListFromPlayersList(monopolyGame.getPlayers());
        assertEquals(playerNames, actualPlayerNames);
    }

    private List<String> getNamesListFromPlayersList(List<Player> playerList) {
        List<String> playerNames = new ArrayList<>();
        for (Player player : playerList) {
            playerNames.add(player.toString());
        }
        return playerNames;
    }
}
