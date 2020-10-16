package gui.listeners;

import gui.controller.MainController;

public class MainMenuListenerImpl implements MainMenuListener {
    private MainController mainController;

    public MainMenuListenerImpl(MainController mainController) {
        this.mainController = mainController;
    }
    @Override
    public void newGameButtonPressed() {
        mainController.showSelectNumberOfPlayersView();
    }
}
