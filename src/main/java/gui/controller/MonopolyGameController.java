package gui.controller;

import gui.MainFrame;
import gui.component.SaveDialog;
import gui.component.Toolbar;
import gui.listeners.ControlPanelListenerImpl;
import gui.listeners.SaveDialogListenerImpl;
import gui.listeners.ToolbarListenerImpl;
import gui.view.*;
import services.MonopolyGameService;
import services.SaveGamesService;
import valueObjects.MonopolyGameValueObject;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;
    private SaveGamesService saveGamesService;
    private PlayersController playersController;
    private BoardController boardController;
    private ControlPanelController controlPanelController;
    private SaveDialog saveDialog;
    private MonopolyGameValueObject monopolyGameValueObject;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
        monopolyGameService = new MonopolyGameService();
        PlayersView playersView = (PlayersView) ViewFactory.getView(ViewFactory.PLAYERS);
        BoardView boardView = (BoardView) ViewFactory.getView(ViewFactory.BOARD);
        ControlPanelView controlPanelView = (ControlPanelView) ViewFactory.getView(ViewFactory.CONTROL_PANEL);
        monopolyGameView.setPlayersView(playersView);
        monopolyGameView.setBoardView(boardView);
        monopolyGameView.setControlPanelView(controlPanelView);
        monopolyGameView.setToolbar(new Toolbar(new ToolbarListenerImpl(this)));
        initializeChildControllers(playersView, boardView, controlPanelView);
        saveDialog = new SaveDialog(MainFrame.mainFrame, SaveDialog.SaveMode.SAVE);
        saveDialog.setSaveDialogListener(new SaveDialogListenerImpl(this));
        saveGamesService = new SaveGamesService();
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

    public void startMonopolyGame(List<String> players) {
        monopolyGameValueObject = monopolyGameService.startMonopolyGame(players);
        initializeGame();
    }

    public void startMonopolyGame(MonopolyGameValueObject monopolyGameValueObject) {
        this.monopolyGameValueObject = monopolyGameValueObject;
        initializeGame();
    }

    private void initializeGame() {
        Map playerColors = attachColorsToPlayers();
        boardController.initializeBoard(monopolyGameService.getBoardspaces(), playerColors);
        playersController.fillPlayerNames(monopolyGameValueObject.playerNames, playerColors);
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

    public void saveGame(String nameGame) {
        try {
            saveGamesService.save(nameGame, monopolyGameValueObject);
        } catch (IOException ioException) {
            System.out.println("Saving game failed.");
        }
    }

    public void hideSaveDialog() {
        saveDialog.setVisible(false);
    }

    public void showSaveDialog() {
        saveDialog.setVisible(true);
    }

    private Map<String, Color> attachColorsToPlayers() {
        Map<String, Color> players = new HashMap<>();
        int i = 0;
        for (String name : monopolyGameValueObject.playerNames) {
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

    public MonopolyGameValueObject getMonopolyGameValueObject() {
        return monopolyGameValueObject;
    }

    public void setMonopolyGameValueObject(MonopolyGameValueObject monopolyGameValueObject) {
        this.monopolyGameValueObject = monopolyGameValueObject;
    }
}
