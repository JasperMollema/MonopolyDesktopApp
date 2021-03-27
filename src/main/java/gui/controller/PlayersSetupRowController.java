package gui.controller;

import gui.listeners.PlayerSetupRowListener;
import gui.view.PlayerSetupRowView;

public class PlayersSetupRowController extends AbstractController {
    private PlayerSetupRowView playerSetupRowView;
    private PlayerSetupRowListener playerSetupRowListener;

    public PlayersSetupRowController(PlayerSetupRowView playerSetupRowView) {
        this.playerSetupRowView = playerSetupRowView;
    }

    @Override
    public String getControllerName() {
        return getClass().getSimpleName();
    }

    @Override
    public void startController() {

    }

    public void setPlayerSetupRowListener(PlayerSetupRowListener playerSetupRowListener) {
        this.playerSetupRowListener = playerSetupRowListener;
    }
}
