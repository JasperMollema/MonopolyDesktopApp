package gui.listeners;

import exceptions.BadNameException;
import gui.controller.MainController;
import gui.controller.SelectNumberOfPlayersController;
import services.SelectNumberOfPlayersService;

public class SelectNumberOfPlayersListenerImpl implements SelectNumberOfPlayersListener {
    private MainController mainController;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;
    private SelectNumberOfPlayersService selectNumberOfPlayersService;

    public SelectNumberOfPlayersListenerImpl(MainController mainController, SelectNumberOfPlayersController selectNumberOfPlayersController) {
        this.mainController = mainController;
        this.selectNumberOfPlayersController = selectNumberOfPlayersController;
        selectNumberOfPlayersService = new SelectNumberOfPlayersService();
    }

    @Override
    public void startGameButtonPressed() {
        int nrOfPlayers = selectNumberOfPlayersController.getNumberOfPlayers();
        for (int i = 0; i < nrOfPlayers; i++) {
            String playerName = selectNumberOfPlayersController.getPlayerName(i + 1);
            addPlayer(playerName);
        }
        mainController.showMonopolyGameView();
    }

    private void addPlayer(String playerName) {
        try {
            selectNumberOfPlayersService.addPlayer(playerName);
        } catch (BadNameException badNameException) {
            // TODO: Add a popup with the message that a same name is added.
        }
    }

    @Override
    public void goToMainMenuButtonPressed() {
        mainController.showMenu();
    }
}
