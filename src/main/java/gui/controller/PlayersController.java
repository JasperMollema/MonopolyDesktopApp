package gui.controller;

import gui.view.PlayersView;

public class PlayersController extends AbstractController {
    private PlayersView playersView;

    public PlayersController(PlayersView playersView) {
        this.playersView = playersView;
    }

    @Override
    public void startController() {
        playersView.initializeView();
    }

    @Override
    public String getControllerName() {
        return "PlayersController";
    }
}
