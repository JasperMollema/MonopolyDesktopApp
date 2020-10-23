package gui.controller;

import gui.view.BoardView;
import gui.view.MonopolyGameView;
import gui.view.PlayersView;
import gui.view.ViewFactory;
import services.MonopolyGameService;

import java.util.Arrays;
import java.util.List;

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;
    private PlayersView playersView;
    private PlayersController playersController;
    private BoardView boardView;
    private BoardController boardController;

    public MonopolyGameController(MonopolyGameView monopolyGameView) {
        this.monopolyGameView = monopolyGameView;
        initializeChildViews();
        initializeChildControllers();
        monopolyGameService = new MonopolyGameService();
    }

    private void initializeChildViews() {
        playersView = (PlayersView) ViewFactory.getView(ViewFactory.PLAYERS);
        boardView = (BoardView) ViewFactory.getView(ViewFactory.BOARD);
        monopolyGameView.setPlayersView(playersView);
        monopolyGameView.setBoardView(boardView);
    }

    private void initializeChildControllers() {
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
        startMonopolyGame(Arrays.asList(new String[]{"Jasper", "Sara"}));
        initializeBoard();
    }

    private void initializeBoard() {
        String[] boardSpaceMessageResources = monopolyGameService.getMonopolyBoardSpacesMessageResources();
        // Initialize board.
    }

    public void startMonopolyGame(List<String> playerNames) {
        monopolyGameService.startMonopolyGame(playerNames);
        monopolyGameView.showChildViews();
    }
}
