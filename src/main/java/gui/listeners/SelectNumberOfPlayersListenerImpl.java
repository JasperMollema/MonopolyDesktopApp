package gui.listeners;

import exceptions.BadNameException;
import gui.controller.MainController;
import gui.controller.SelectNumberOfPlayersController;
import services.SelectNumberOfPlayersService;

public class SelectNumberOfPlayersListenerImpl implements SelectNumberOfPlayersListener {
    private MainController mainController;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;
    private SelectNumberOfPlayersService selectNumberOfPlayersService;
    private boolean incorrectInput;

    public SelectNumberOfPlayersListenerImpl(MainController mainController, SelectNumberOfPlayersController selectNumberOfPlayersController) {
        this.mainController = mainController;
        this.selectNumberOfPlayersController = selectNumberOfPlayersController;
        selectNumberOfPlayersService = new SelectNumberOfPlayersService();
    }

    @Override
    public void startGameButtonPressed() {
        int nrOfPlayers = selectNumberOfPlayersController.getNumberOfPlayers();

        for (int i = 0; i < nrOfPlayers && !incorrectInput; i++) {
            String playerName = selectNumberOfPlayersController.getPlayerName(i + 1);
            addPlayer(playerName);
        }

        if (incorrectInput) {
            incorrectInput = false;
            return;
        }

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
            selectNumberOfPlayersController.showWarningMessagesEmptyName();
        }

        if (badNameType == BadNameException.BadNameType.IDENTICAL_NAME) {
            selectNumberOfPlayersController.showWarningMessageSamePlayerNames();
        }

        incorrectInput = true;
    }

    @Override
    public void goToMainMenuButtonPressed() {
        mainController.showMenu();
    }
}
