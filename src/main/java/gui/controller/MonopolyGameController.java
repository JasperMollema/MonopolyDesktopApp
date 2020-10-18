package gui.controller;

import gui.view.MonopolyGameView;
import gui.view.PlayersView;
import gui.view.ViewFactory;
import services.MonopolyGameService;

import java.util.List;

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;
    private PlayersView playersView;
    private PlayersController playersController;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
        initializeChildViews();
        initializeChildControllers();
        monopolyGameService = new MonopolyGameService();
    }

    private void initializeChildViews() {
        playersView = (PlayersView) ViewFactory.getView(ViewFactory.PLAYERS);
        monopolyGameView.setPlayersView(playersView);
    }

    private void initializeChildControllers() {
        playersController = (PlayersController) ControllerFactory.getController(playersView);
    }

    @Override
    public String getControllerName() {
        return "MonopolyGameController";
    }

    @Override
    public void startController() {
        monopolyGameView.initializeView();
        playersController.startController();
    }

    public void startMonopolyGame(List<String> playerNames) {
        monopolyGameService.startMonopolyGame(playerNames);
        monopolyGameView.showChildViews();
    }
}
