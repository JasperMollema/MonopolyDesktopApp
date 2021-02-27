package gui.controller;

import gui.listeners.MainMenuListener;
import gui.view.MainMenuBagView;

public class MenuController extends AbstractController {
    private final String NAME_CONTROLLER = "MenuController";

    private MainMenuBagView mainMenuView;
    private MainMenuListener mainMenuListener;

    public MenuController(MainMenuBagView mainMenuView) {
        this.mainMenuView = mainMenuView;

        addActionListenerToNewGameButton();
        addActionListenerToLoadGameButton();
        addActionListenerToChooseLanguageButton();
    }

    private void addActionListenerToNewGameButton() {
        mainMenuView.setActionListenerNewGameButton(
                event -> mainMenuListener.newGameButtonPressed());
    }

    private void addActionListenerToLoadGameButton() {
        mainMenuView.setActionListenerToLoadGameButton(
                event -> mainMenuListener.loadGameButtonPressed());
    }

    private void addActionListenerToChooseLanguageButton() {
        mainMenuView.setActionListenerToLanguageButton(
                event -> mainMenuListener.languageButtonPressed());
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }

    @Override
    public void startController() {
        mainMenuView.initializeView();
    }

    public void setMainMenuListener(MainMenuListener mainMenuListener) {
        this.mainMenuListener = mainMenuListener;
    }
}
