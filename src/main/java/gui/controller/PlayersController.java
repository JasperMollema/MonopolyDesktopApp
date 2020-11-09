package gui.controller;

import gui.view.PlayersView;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class PlayersController extends AbstractController {
    private PlayersView playersView;

    public PlayersController(PlayersView playersView) {
        this.playersView = playersView;
    }

    @Override
    public void startController() {
        playersView.initializeView();
    }

    public void fillPlayerNames(List<String> playerNames, Map<String, Color> players) {
        int playerNumber = 0;
        for (String name : playerNames) {
            addPlayerToView(playerNumber, name, players.get(name));
        }
    }

    private void addPlayerToView(int playerNumber, String name, Color color) {
        switch (playerNumber) {
            case 0: playersView.initializePlayer1(name, color);
            break;
            case 1: playersView.initializePlayer2(name, color);
            break;
            case 2: playersView.initializePlayer3(name, color);
            break;
            case 3: playersView.initializePlayer4(name, color);
            break;
            case 4: playersView.initializePlayer5(name, color);
            break;
            case 5: playersView.initializePlayer6(name, color);
            break;
            default: return;
        }
    }

    @Override
    public String getControllerName() {
        return "PlayersController";
    }
}
