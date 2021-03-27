package gui.view;

public class ViewFactory {
    public static final String MAIN = "main";
    public static final String MENU = "menu";
    public static final String SETUP_PLAYERS = "setupPlayers";
    public static final String SETUP_PLAYERS_ROW = "setupPlayersRow";
    public static final String MONOPOLY_GAME = "monopolyGame";
    public static final String PLAYERS = "players";
    public static final String BOARD = "board";
    public static final String CONTROL_PANEL = "controlPanel";
    public static final String CHOOSE_LANGUAGE = "chooseLanguage";

    public static View getView(String view) {
        switch (view) {
            case MAIN: return new MainView();
            case MENU: return new MainMenuBagView();
            case SETUP_PLAYERS: return new PlayersSetupView();
            case SETUP_PLAYERS_ROW: return new PlayerSetupRowView();
            case MONOPOLY_GAME: return new MonopolyGameView();
            case PLAYERS: return new PlayersView();
            case BOARD: return new BoardView();
            case CONTROL_PANEL: return new ControlPanelView();
            case CHOOSE_LANGUAGE: return new ChooseLanguageView();
            default: return new NullView();
        }
    }

    private static class NullView implements View {
        @Override
        public void initializeView() {

        }
    }
}
