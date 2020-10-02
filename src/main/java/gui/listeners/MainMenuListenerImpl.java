package gui.listeners;

import commands.StartMonopolyGameCommand;
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
        StartMonopolyGameCommand startMonopolyGameCommand = new StartMonopolyGameCommand();
        startMonopolyGameCommand.setMainController(mainController);
        startMonopolyGameCommand.execute();
    }
}
