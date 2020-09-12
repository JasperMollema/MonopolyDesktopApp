package gui.controller;

import gui.view.MainView;
import gui.view.MenuView;
import gui.view.SelectNumberOfPlayersView;
import gui.view.View;

public class ControllerFactory {

    public static Controller getController(View view) {
        if (view instanceof MainView) {
            return new MainController((MainView) view);
        }
        else if (view instanceof MenuView) {
            return new MenuController((MenuView) view);
        }

        else if (view instanceof SelectNumberOfPlayersView) {
            return new SelectNumberOfPlayersController((SelectNumberOfPlayersView) view);
        }

        else return new NullController();
    }

    private static class NullController implements Controller {
        @Override
        public void startView() {

        }
    }
}
