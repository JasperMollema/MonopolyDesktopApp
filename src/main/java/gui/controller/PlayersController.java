package gui.controller;

import gui.view.PlayersView;

import java.util.List;

public class PlayersController extends AbstractController {
    private PlayersView playersView;

    public PlayersController(PlayersView playersView) {
        this.playersView = playersView;
    }

    @Override
    public void startController() {
        playersView.initializeView();
    }

    public void fillPlayerNames(List<String> playerNames) {
        for (int i = 0; i < playerNames.size(); i++) {
            addPlayerToView(playerNames.get(i), i);
        }
    }

    private void addPlayerToView(String name, int index) {
        switch (index) {
            case 0: playersView.initializePlayer1(name);
            break;
            case 1: playersView.initializePlayer2(name);
            break;
            case 2: playersView.initializePlayer3(name);
            break;
            case 3: playersView.initializePlayer4(name);
            break;
            case 4: playersView.initializePlayer5(name);
            break;
            case 5: playersView.initializePlayer6(name);
            break;
            default: return;
        }
    }

    @Override
    public String getControllerName() {
        return "PlayersController";
    }
}
