package gui.view;

public class ViewFactory {
    public static final String MAIN = "main";
    public static final String MENU = "menu";
    public static final String SELECT_NR_OF_PLAYERS = "selectNrOfPlayers";
    public static final String MONOPOLY_GAME = "monopolyGame";
    public static final String PLAYERS = "players";
    public static final String BOARD = "board";
    public static final String CONTROL_PANEL = "controlPanel";

    public static View getView(String view) {
        switch (view) {
            case MAIN: return new MainView();
            case MENU: return new MainMenuBagView();
            case SELECT_NR_OF_PLAYERS: return new SelectNumberOfPlayersView();
            case MONOPOLY_GAME: return new MonopolyGameView();
            case PLAYERS: return new PlayersView();
            case BOARD: return new BoardView();
            case CONTROL_PANEL: return new ControlPanelView();
            default: return new NullView();
        }
    }

    private static class NullView implements View {
        @Override
        public void initializeView() {

        }
    }
}
