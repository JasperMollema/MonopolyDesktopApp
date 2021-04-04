package gui.listeners;

import exceptions.BadNameException;
import gui.controller.MainController;
import gui.controller.PlayersSetupController;
import services.PlayersSetupService;
import valueObjects.PlayerValueObject;

import java.util.List;

public class PlayersSetupListenerImpl implements PlayersSetupListener {
    private MainController mainController;
    private PlayersSetupController playersSetupController;
    private PlayersSetupService playersSetupService;

    public PlayersSetupListenerImpl(MainController mainController, PlayersSetupController playersSetupController) {
        this.mainController = mainController;
        this.playersSetupController = playersSetupController;
        playersSetupService = new PlayersSetupService();
    }

    @Override
    public void startGameButtonPressed() {
        List<PlayerValueObject> playerValueObjects = playersSetupController.getPlayerValueObjects();
        for (PlayerValueObject playerValueObject : playerValueObjects) {
            addPlayer(playerValueObject);
        }
        mainController.startMonopolyGame(playersSetupService.getPlayers());
    }

    private void addPlayer(PlayerValueObject playerValueObject) {
        try {
            playersSetupService.addPlayer(playerValueObject);
        } catch (BadNameException badNameException) {
            handleBadNameException(badNameException.getBadNameType());
        }
    }

    private void handleBadNameException(BadNameException.BadNameType badNameType) {
        if (badNameType == BadNameException.BadNameType.EMPTY_NAME) {
            playersSetupController.showWarningMessagesEmptyName();
        }

        if (badNameType == BadNameException.BadNameType.IDENTICAL_NAME) {
            playersSetupController.showWarningMessageSamePlayerNames();
        }
    }

    @Override
    public void goToMainMenuButtonPressed() {
        playersSetupController.clear();
        mainController.showMenu();
    }
}
