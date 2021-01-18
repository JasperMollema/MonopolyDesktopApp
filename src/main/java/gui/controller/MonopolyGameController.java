package gui.controller;

import gui.view.BoardView;
import gui.view.MonopolyGameView;
import gui.view.PlayersView;
import gui.view.ViewFactory;
import services.MonopolyGameService;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Ik denk niet dat deze controller gelijke controlle moet hebben over de views. Hij kan
 delegeren aan de childcontrollers. Alleen het de control panel/view ontvangt daadwerklijk input van de gebruiker.
 dus daar kan een listener op komen. */

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;
    private PlayersController playersController;
    private BoardController boardController;
    private List<String> playerNames;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
        PlayersView playersView = (PlayersView) ViewFactory.getView(ViewFactory.PLAYERS);
        BoardView boardView = (BoardView) ViewFactory.getView(ViewFactory.BOARD);
        monopolyGameView.setPlayersView(playersView);
        monopolyGameView.setBoardView(boardView);
        initializeChildControllers(playersView, boardView);
        monopolyGameService = new MonopolyGameService();
    }

    private void initializeChildControllers(PlayersView playersView, BoardView boardView) {
        playersController = (PlayersController) ControllerFactory.getController(playersView);
        boardController = (BoardController) ControllerFactory.getController(boardView);
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

    private void initializeBoard(Map<String, Color> playerColors) {
        String[] boardComponentMessageResources = monopolyGameService.getMonopolyBoardSpacesMessageResources();
        boardController.initializeBoard(boardComponentMessageResources, playerColors);
    }

    public void startMonopolyGame(List<String> playerNames) {
        this.playerNames = playerNames;
        Map playerColors = attachColorsToPlayers();
        initializeBoard(playerColors);
        playersController.fillPlayerNames(this.playerNames, playerColors);
        monopolyGameService.startMonopolyGame(this.playerNames);
        monopolyGameView.showChildViews();
        setPlayersOnBoard();
    }

    private void setPlayersOnBoard() {
        for (String name : playerNames) {
            boardController.setPlayerOnStart(name);
        }
    }

    private Map<String, Color> attachColorsToPlayers() {
        Map<String, Color> players = new HashMap<>();
        int i = 0;
        for (String name : playerNames) {
            players.put(name, getColor(i));
            i++;
        }
        return players;
    }

    private Color getColor(int index) {
        switch (index) {
            case 0 : return Color.RED;
            case 1 : return Color.BLUE;
            case 2 : return Color.GREEN;
            case 3 : return Color.YELLOW;
            case 4 : return Color.PINK;
            case 5 : return Color.CYAN;
        }
        return null;
    }
}
