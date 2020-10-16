package gui.controller;

import gui.view.MonopolyGameView;

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
    }

    @Override
    public String getControllerName() {
        return "MonopolyGameController";
    }

    @Override
    public void startController() {

    }
}
