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

        else return new NullController();
    }

    private static class NullController implements Controller {
        @Override
        public void startController() {

        }
    }
}
