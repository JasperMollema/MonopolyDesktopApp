package services;

public class TestPlayersSetupService {
    PlayersSetupService playersSetupService;
    String name = "name";
    String differentName = "differentName";

//    @BeforeEach
//    void initialize() {
//        playersSetupService = new PlayersSetupService();
//    }
//
//    @Test
//    void canNotAddPlayersWithSameName() throws BadNameException {
//        playersSetupService.addPlayer(name);
//        assertThrows(IdenticalNameException.class, () -> playersSetupService.addPlayer(name));
//        assertTrue(numberOfPlayersIs(0));
//    }
//
//    @Test
//    void canAddPlayerWithDifferentName() throws BadNameException {
//        playersSetupService.addPlayer(name);
//        playersSetupService.addPlayer(differentName);
//        assertTrue(numberOfPlayersIs(2));
//    }
//
//    @Test
//    void testEmptyName() {
//        assertThrows(EmptyNameException.class, () -> playersSetupService.addPlayer(null));
//        assertThrows(EmptyNameException.class, () -> playersSetupService.addPlayer(""));
//        assertThrows(EmptyNameException.class, () -> playersSetupService.addPlayer("    "));
//        assertTrue(numberOfPlayersIs(0));
//    }
//
//    @Test
//    void testNameTooLong() {
//        assertThrows(RuntimeException.class, () -> playersSetupService.addPlayer(createNameThatIsTooLong()));
//        assertTrue(numberOfPlayersIs(0));
//    }
//
//    private boolean numberOfPlayersIs(int numberOfPlayers) {
//        return playersSetupService.getPlayers().size() == numberOfPlayers;
//    }
//
//    private String createNameThatIsTooLong() {
//        int lengthTooLong = Settings.MAX_LENGTH_PLAYER_NAME + 1;
//        StringBuilder tooLongName = new StringBuilder();
//        for (int i = 0; i < lengthTooLong; i++) {
//            tooLongName.append("a");
//        }
//        return tooLongName.toString();
//    }
}
