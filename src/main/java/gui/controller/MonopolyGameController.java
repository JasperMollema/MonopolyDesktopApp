package gui.controller;

import gui.view.MonopolyGameView;
import services.MonopolyGameService;

import java.util.List;

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
        monopolyGameService = new MonopolyGameService();
    }

    @Override
    public String getControllerName() {
        return "MonopolyGameController";
    }

    @Override
    public void startController() {
    }

    public void startMonopolyGame(List<String> playerNames) {
        monopolyGameService.startMonopolyGame(playerNames);
    }
}
