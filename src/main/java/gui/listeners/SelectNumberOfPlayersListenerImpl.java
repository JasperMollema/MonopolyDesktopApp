package gui.listeners;

import gui.controller.MainController;
import gui.controller.SelectNumberOfPlayersController;
import service.SelectNumberOfPlayersService;

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
            selectNumberOfPlayersService.addPlayer(playerName);
        }
        mainController.showMonopolyGameView();
    }

    @Override
    public void goToMainMenuButtonPressed() {
        mainController.showMenu();
    }
}
