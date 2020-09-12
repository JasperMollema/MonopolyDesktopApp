package gui.view;

public class ViewFactory {
    public static final String MAIN = "main";
    public static final String MENU = "menu";
    public static final String SELECT_NR_OF_PLAYERS = "selectNrOfPlayers";

    public static View getView(String view) {
        switch (view) {
            case MAIN: return new MainView();
            case MENU: return new MenuView();
            case SELECT_NR_OF_PLAYERS: return new SelectNumberOfPlayersView();
            default: return new NullView();
        }
    }

    private static class NullView implements View {
        @Override
        public void initializeView() {

        }
    }
}
