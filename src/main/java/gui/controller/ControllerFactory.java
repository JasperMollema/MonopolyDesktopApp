package gui.controller;

import gui.view.*;

public class ControllerFactory {

    public static Controller getController(View view) {
        if (view instanceof MainView) {
            return new MainController((MainView) view);
        }

        else if (view instanceof MainMenuBagView) {
            return new MenuController((MainMenuBagView) view);
        }

        else if (view instanceof SelectNumberOfPlayersView) {
            return new SelectNumberOfPlayersController((SelectNumberOfPlayersView) view);
        }

        else if (view instanceof MonopolyGameView) {
            return new MonopolyGameController((MonopolyGameView) view);
        }

        else if (view instanceof PlayersView) {
            return new PlayersController((PlayersView) view);
        }

        else if (view instanceof BoardView) {
            return new BoardController((BoardView) view);
        }

        else if (view instanceof ControlPanelView) {
            return new ControlPanelController((ControlPanelView) view);
        }

        else if (view instanceof ChooseLanguageView) {
            return new ChooseLanguageController((ChooseLanguageView) view);
        }

        else return new NullController();
    }

    private static class NullController implements Controller {
        @Override
        public void startController() {

        }
    }
}
