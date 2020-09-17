package gui.listeners;

import gui.controller.MainController;
import service.MainMenuService;

public class MainMenuListenerImpl implements MainMenuListener {
    private MainController mainController;
    private MainMenuService mainMenuService;

    public MainMenuListenerImpl(MainController mainController) {
        this.mainController = mainController;
        mainMenuService = new MainMenuService();
    }
    @Override
    public void newGameButtonPressed() {
        mainController.showSelectNumberOfPlayersView();
        mainMenuService.startNewGame();
    }
}
