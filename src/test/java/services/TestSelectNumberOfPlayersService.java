package services;

import exceptions.BadNameException;
import exceptions.EmptyNameException;
import exceptions.IdenticalNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import settings.Settings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSelectNumberOfPlayersService {
    SelectNumberOfPlayersService selectNumberOfPlayersService;
    String name = "name";
    String differentName = "differentName";

    @BeforeEach
    void initialize() {
        selectNumberOfPlayersService = new SelectNumberOfPlayersService();
    }

    @Test
    void canNotAddPlayersWithSameName() throws BadNameException {
        selectNumberOfPlayersService.addPlayer(name);
        assertThrows(IdenticalNameException.class, () -> selectNumberOfPlayersService.addPlayer(name));
        assertTrue(numberOfPlayersIs(0));
    }

    @Test
    void canAddPlayerWithDifferentName() throws BadNameException {
        selectNumberOfPlayersService.addPlayer(name);
        selectNumberOfPlayersService.addPlayer(differentName);
        assertTrue(numberOfPlayersIs(2));
    }

    @Test
    void testEmptyName() {
        assertThrows(EmptyNameException.class, () -> selectNumberOfPlayersService.addPlayer(null));
        assertThrows(EmptyNameException.class, () -> selectNumberOfPlayersService.addPlayer(""));
        assertThrows(EmptyNameException.class, () -> selectNumberOfPlayersService.addPlayer("    "));
        assertTrue(numberOfPlayersIs(0));
    }

    @Test
    void testNameTooLong() {
        assertThrows(RuntimeException.class, () -> selectNumberOfPlayersService.addPlayer(createNameThatIsTooLong()));
        assertTrue(numberOfPlayersIs(0));
    }

    private boolean numberOfPlayersIs(int numberOfPlayers) {
        return selectNumberOfPlayersService.getPlayerList().size() == numberOfPlayers;
    }

    private String createNameThatIsTooLong() {
        int lengthTooLong = Settings.MAX_LENGTH_PLAYER_NAME + 1;
        StringBuilder tooLongName = new StringBuilder();
        for (int i = 0; i < lengthTooLong; i++) {
            tooLongName.append("a");
        }
        return tooLongName.toString();
    }
}
