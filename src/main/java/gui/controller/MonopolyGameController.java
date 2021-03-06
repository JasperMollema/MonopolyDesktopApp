package gui.controller;

import gui.MainFrame;
import gui.component.SaveDialog;
import gui.component.Toolbar;
import gui.listeners.ControlPanelListenerImpl;
import gui.listeners.MonopolyGameListener;
import gui.listeners.SaveDialogListenerImpl;
import gui.listeners.ToolbarListenerImpl;
import gui.view.*;
import services.MonopolyGameService;
import valueObjects.MonopolyGameValueObject;
import valueObjects.PlayerValueObject;

import java.util.List;
import java.util.Map;

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;
    private PlayersController playersController;
    private BoardController boardController;
    private ControlPanelController controlPanelController;
    private MonopolyGameListener monopolyGameListener;
    private SaveDialog saveDialog;
    private MonopolyGameValueObject monopolyGameValueObject;
    private boolean hasUnSavedChanges;

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

    public void loadMonopolyGame(List<PlayerValueObject> players) {
        monopolyGameValueObject = monopolyGameService.startMonopolyGame(players);
        initializeGame();
    }

    public void loadMonopolyGame(MonopolyGameValueObject monopolyGameValueObject) {
        this.monopolyGameValueObject = monopolyGameValueObject;
        monopolyGameService.loadMonopolyGame(monopolyGameValueObject);
        initializeGame();
    }

    private void initializeGame() {
        boardController.initializeBoard(monopolyGameService.getBoardspaces(), monopolyGameValueObject.players);
        playersController.fillPlayers(monopolyGameValueObject.players);
        setPlayersOnBoard(monopolyGameValueObject.playerPositions);
        controlPanelController.fillInfoMessage1("controlPanel.playerTurn", new String[]{monopolyGameValueObject.activePlayer});
        monopolyGameView.showChildViews();
    }

    public void setPlayersOnBoard(Map<String, Integer> playerPositions) {
        for (String name : playerPositions.keySet()) {
            boardController.setPlayerOnBoardComponent(name, playerPositions.get(name));
        }
    }

    public void movePlayer(String player, int newPosition) {
        int oldPosition = monopolyGameValueObject.playerPositions.get(player);
        boardController.removePlayerFromBoardComponent(player, oldPosition);
        boardController.setPlayerOnBoardComponent(player, newPosition);
    }

    public void goToMainMenu() {
        monopolyGameListener.goToMainMenu();
        boardController.emptyBoard();
        playersController.emptyPlayers();
        monopolyGameValueObject = null;
    }

    public void hideSaveDialog() {
        saveDialog.setVisible(false);
    }

    public void showSaveDialog() {
        saveDialog.initializeGamesList();
        saveDialog.setVisible(true);
    }

    public MonopolyGameValueObject getMonopolyGameValueObject() {
        return monopolyGameValueObject;
    }

    public void setMonopolyGameValueObject(MonopolyGameValueObject monopolyGameValueObject) {
        this.monopolyGameValueObject = monopolyGameValueObject;
    }

    public boolean hasUnSavedChanges() {
        return hasUnSavedChanges;
    }

    public void setHasUnSavedChanges(boolean hasUnSavedChanges) {
        this.hasUnSavedChanges = hasUnSavedChanges;
    }

    public void setMonopolyGameListener(MonopolyGameListener monopolyGameListener) {
        this.monopolyGameListener = monopolyGameListener;
    }
}
