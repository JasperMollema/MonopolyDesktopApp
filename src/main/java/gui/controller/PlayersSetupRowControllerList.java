package gui.controller;

import settings.Settings;

import java.util.ArrayList;

public class PlayersSetupRowControllerList extends ArrayList<PlayersSetupRowController> {

    public void startPlayersSetupRowControllers() {
        for (PlayersSetupRowController playersSetupRowController : this) {
            playersSetupRowController.startController();
            showRows(Settings.DEFAULT_NR_OF_PLAYERS);
        }
    }

    public void showRows(int nrOfRows) {
        for (PlayersSetupRowController playersSetupRowController : this) {
            boolean showRow = indexOf(playersSetupRowController) < nrOfRows;
            playersSetupRowController.setVisibilityRow(showRow);
        }
    }
}
