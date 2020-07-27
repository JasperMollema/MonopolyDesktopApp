package gui.controller;

import gui.view.AbstractView;

public class ControllerFactory {
    public static final String SELECT_NUMBER_OF_PLAYERS = "selectNrOfPlayers";

    public static Controller getController(String controller) {
        switch (controller) {
            case SELECT_NUMBER_OF_PLAYERS :
                return new SelectNumberOfPlayersController();
        }
        return new NullController();
    }

    private static class NullController extends AbstractController {
        @Override
        public void setView(AbstractView view) {}
    }
}
