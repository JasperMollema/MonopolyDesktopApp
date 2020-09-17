package gui.listeners;

import gui.controller.MainController;

public class SelectNumberOfPlayersListenerImpl implements SelectNumberOfPlayersListener {
    private MainController mainController;

    public SelectNumberOfPlayersListenerImpl(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void startGameButtonPressed() {
        mainController.showMonopolyGameView();

    }

    @Override
    public void goToMainMenuButtonPressed() {
        mainController.showMenu();
    }
}
