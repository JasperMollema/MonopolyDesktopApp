package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMonopolyGame {
    @Test
    void gameShouldNotHaveMoreThanSixPlayers() {
        assertThrows(RuntimeException.class, () -> new MonopolyGame(createListWithSevenPlayers()));
    }

    @Test
    void gameShouldHaveMinimalTwoPlayers() {
        assertThrows(RuntimeException.class, () -> new MonopolyGame(createListWithOnePlayer()));
        assertThrows(RuntimeException.class, () -> new MonopolyGame(null));
        assertThrows(RuntimeException.class, () -> new MonopolyGame(new ArrayList<>()));
    }

    private List<Player> createListWithSevenPlayers() {
        List<Player> playerList = new ArrayList<>();
        String name = "name";
        for (int i = 0; i < 7; i++) {
            playerList.add(new Player(name + i));
        }
        return playerList;
    }

    private List<Player> createListWithOnePlayer() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("name"));
        return playerList;
    }
}
