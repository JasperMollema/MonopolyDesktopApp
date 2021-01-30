package gui.controller;

import gui.listeners.ControlPanelListenerImpl;
import gui.view.*;
import services.MonopolyGameService;
import valueObjects.BoardSpaceValueObject;
import valueObjects.MonopolyGameValueObject;

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
    private ControlPanelController controlPanelController;
    private List<String> playerNames;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
        monopolyGameService = new MonopolyGameService();
        PlayersView playersView = (PlayersView) ViewFactory.getView(ViewFactory.PLAYERS);
        BoardView boardView = (BoardView) ViewFactory.getView(ViewFactory.BOARD);
        ControlPanelView controlPanelView = (ControlPanelView) ViewFactory.getView(ViewFactory.CONTROL_PANEL);
        monopolyGameView.setPlayersView(playersView);
        monopolyGameView.setBoardView(boardView);
        monopolyGameView.setControlPanelView(controlPanelView);
        initializeChildControllers(playersView, boardView, controlPanelView);
    }

    private void initializeChildControllers(PlayersView playersView, BoardView boardView, ControlPanelView controlPanelView) {
        playersController = (PlayersController) ControllerFactory.getController(playersView);
        boardController = (BoardController) ControllerFactory.getController(boardView);
        controlPanelController = (ControlPanelController) ControllerFactory.getController(controlPanelView);
        controlPanelController.setControlPanelListener(new ControlPanelListenerImpl(this, controlPanelController, monopolyGameService));
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
        List<BoardSpaceValueObject> boardSpaceValueObjects = monopolyGameService.getMonopolyGameValueObject().boardSpaces;
        boardController.initializeBoard(boardSpaceValueObjects, playerColors);
    }

    public void startMonopolyGame(List<String> players) {
        playerNames = players;
        Map playerColors = attachColorsToPlayers();
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameService.startMonopolyGame(playerNames);
        initializeBoard(playerColors);
        playersController.fillPlayerNames(playerNames, playerColors);
        setPlayersOnBoard(monopolyGameValueObject.playerPositions);
        controlPanelController.fillInfoMessage1("controlPanel.playerTurn", new String[]{monopolyGameValueObject.activePlayer});
        controlPanelController.showInfoMessage1();
        monopolyGameView.showChildViews();
    }

    public void setPlayersOnBoard(Map<String, Integer> playerPositions) {
        for (String name : playerPositions.keySet()) {
            boardController.setPlayerOnBoardComponent(name, playerPositions.get(name));
        }
    }

    public void movePlayer(String player, int oldPosition, int newPosition) {
        boardController.removePlayerFromBoardComponent(player, oldPosition);
        boardController.setPlayerOnBoardComponent(player, newPosition);
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
