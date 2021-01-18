package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayerNameValidator {
    private final String NAME_1 = "name1";
    private final String NAME_2 = "name2";
    private final String NAME_3 = "name3";
    private final String NAME_4 = "name4";
    private final String NAME_5 = "name5";
    private final String NAME_6 = "name6";
    private final String NAME_7 = "name7";

    private final List<String> onePlayer = Arrays.asList(NAME_1);
    private final List<String> twoPlayers = Arrays.asList(NAME_1, NAME_2);
    private final List<String> sixPlayers = Arrays.asList(NAME_1, NAME_2, NAME_3, NAME_4, NAME_5, NAME_6);
    private final List<String> sevenPlayers = Arrays.asList(NAME_1, NAME_2, NAME_3, NAME_4, NAME_5, NAME_6, NAME_7);
    private final List<String> identicalPlayers = Arrays.asList(NAME_1, NAME_1);

   @Test
   void gameCouldNotHaveOnePlayer() {
        assertFalse(PlayerNameValidator.validatePlayers(onePlayer));
   }

   @Test
   void gameCouldHaveTwoPlayers() {
        assertTrue(PlayerNameValidator.validatePlayers(twoPlayers));
   }

    @Test
    void gameCouldHaveSixPlayers() {
        assertTrue(PlayerNameValidator.validatePlayers(sixPlayers));
    }

    @Test
    void gameCouldHaveSevenPlayers() {
        assertFalse(PlayerNameValidator.validatePlayers(sevenPlayers));
    }

    @Test
    void canNotCreateAGameWithTwoIdenticalPlayers() {
        assertFalse(PlayerNameValidator.validatePlayers(identicalPlayers));
    }
}
