package gui.controller;

import gui.listeners.MainMenuListener;
import gui.view.MainMenuView;

public class MenuController extends AbstractController {
    private MainMenuView mainMenuView;
    private final String NAME_CONTROLLER = "MenuController";
    private MainMenuListener mainMenuListener;

    public MenuController(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
        addActionListenersToNewGameButton();
    }

    private void addActionListenersToNewGameButton() {
        mainMenuView.setActionListenerNewGameButton(
                event -> {
                    mainMenuListener.newGameButtonPressed();
                }
        );
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }

    @Override
    public void startView() {
        mainMenuView.initializeView();
    }

    public void setMainMenuListener(MainMenuListener mainMenuListener) {
        this.mainMenuListener = mainMenuListener;
    }
}
