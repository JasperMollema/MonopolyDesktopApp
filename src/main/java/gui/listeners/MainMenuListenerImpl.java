package gui.listeners;

import commands.StartMonopolyGameCommand;
import gui.controller.MainController;

public class MainMenuListenerImpl implements MainMenuListener {
    private MainController mainController;

    public MainMenuListenerImpl(MainController mainController) {
        this.mainController = mainController;
    }
    @Override
    public void newGameButtonPressed() {
        StartMonopolyGameCommand startMonopolyGameCommand = new StartMonopolyGameCommand();
        startMonopolyGameCommand.setMainController(mainController);
        startMonopolyGameCommand.execute();
    }
}
