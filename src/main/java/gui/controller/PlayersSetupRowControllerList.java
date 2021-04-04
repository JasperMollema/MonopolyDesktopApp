package gui.controller;

import settings.Settings;
import valueObjects.PlayerValueObject;

import java.util.ArrayList;
import java.util.List;

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

    public List<PlayerValueObject> getPlayerValueObjects() {
        List<PlayerValueObject> playerValueObjects = new ArrayList<>();
        for (PlayersSetupRowController playersSetupRowController : this) {
            playerValueObjects.add(playersSetupRowController.getPlayerValueObject());
        }
        return playerValueObjects;
    }
}
