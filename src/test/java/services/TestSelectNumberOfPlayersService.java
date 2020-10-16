package services;

import exceptions.BadNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(BadNameException.class, () -> selectNumberOfPlayersService.addPlayer(name));
    }

    @Test
    void canAddPlayerWithDifferentName() throws BadNameException {
        selectNumberOfPlayersService.addPlayer(name);
        selectNumberOfPlayersService.addPlayer(differentName);
    }

    @Test
    void testEmptyName() throws BadNameException {

    }
}
