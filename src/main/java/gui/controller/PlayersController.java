package gui.controller;

import gui.component.ComboBoxColor;
import gui.view.PlayersView;
import valueObjects.PlayerValueObject;

import java.awt.*;
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

    public void fillPlayers(List<PlayerValueObject> players) {
        int playerNumber = 0;
        for (PlayerValueObject playerValueObject : players) {
            ComboBoxColor comboBoxColor = ComboBoxColor.valueOf(playerValueObject.playerColor);
            Color playerColor = comboBoxColor.getColor();
            String playerName = playerValueObject.name;
            addPlayerToView(playerNumber++, playerName, playerColor);
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

    public void emptyPlayers() {
        playersView.emptyPlayers();
    }
}
