package gui.listeners;

import gui.controller.MainController;

public class MonopolyGameListenerImpl implements MonopolyGameListener {
    private MainController mainController;

    public MonopolyGameListenerImpl(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void goToMainMenu() {
        mainController.refresh();
        mainController.showMenu();
    }
}
