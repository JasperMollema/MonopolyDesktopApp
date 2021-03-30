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
        playerSetupRowView.initializeView();
    }

    public void setVisibilityRow(boolean showRow) {
        playerSetupRowView.setVisibilityComponents(showRow);
    }

    public void fillRowNr(int rowNr) {
        playerSetupRowView.setRowNr(rowNr);
    }

    public void setPlayerSetupRowListener(PlayerSetupRowListener playerSetupRowListener) {
        this.playerSetupRowListener = playerSetupRowListener;
    }
}
