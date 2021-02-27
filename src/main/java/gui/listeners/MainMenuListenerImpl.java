package gui.listeners;

import gui.controller.MainController;
import gui.controller.MenuController;

public class MainMenuListenerImpl implements MainMenuListener {
    private MainController mainController;
    private MenuController menuController;

    public MainMenuListenerImpl(MainController mainController, MenuController menuController) {
        this.mainController = mainController;
        this.menuController = menuController;
    }

    @Override
    public void newGameButtonPressed() {
        mainController.showSelectNumberOfPlayersView();
    }

    @Override
    public void loadGameButtonPressed() {
        mainController.showLoadGameDialog();
    }

    @Override
    public void languageButtonPressed() {
        mainController.showChooseLanguageView();
    }
}
