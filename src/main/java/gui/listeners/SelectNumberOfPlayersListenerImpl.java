package gui.listeners;

import exceptions.BadNameException;
import gui.controller.MainController;
import gui.controller.PlayersSetupController;
import services.SelectNumberOfPlayersService;

public class SelectNumberOfPlayersListenerImpl implements SelectNumberOfPlayersListener {
    private MainController mainController;
    private PlayersSetupController playersSetupController;
    private SelectNumberOfPlayersService selectNumberOfPlayersService;
    private boolean incorrectInput;

    public SelectNumberOfPlayersListenerImpl(MainController mainController, PlayersSetupController playersSetupController) {
        this.mainController = mainController;
        this.playersSetupController = playersSetupController;
        selectNumberOfPlayersService = new SelectNumberOfPlayersService();
    }

    @Override
    public void startGameButtonPressed() {
//        List<PlayerSetupRowView> playerNames = playersSetupController.getPlayerRows();
        mainController.startMonopolyGame(selectNumberOfPlayersService.getPlayerNamesList());
    }

    private void addPlayer(String playerName) {
        try {
            selectNumberOfPlayersService.addPlayerName(playerName);
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

        incorrectInput = true;
    }

    @Override
    public void goToMainMenuButtonPressed() {
        playersSetupController.clear();
        mainController.showMenu();
    }
}
