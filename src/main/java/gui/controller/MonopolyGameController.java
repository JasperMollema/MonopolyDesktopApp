package gui.controller;

import gui.view.BoardView;
import gui.view.MonopolyGameView;
import gui.view.PlayersView;
import gui.view.ViewFactory;
import services.MonopolyGameService;

import java.util.Arrays;
import java.util.List;

/** Ik denk niet dat deze controller gelijke controlle moet hebben over de views. Hij kan
 delegeren aan de childcontrollers. Alleen het de control panel/view ontvangt daadwerklijk input van de gebruiker.
 dus daar kan een listener op komen. */

public class MonopolyGameController extends AbstractController {
    private MonopolyGameView monopolyGameView;
    private MonopolyGameService monopolyGameService;
    private PlayersController playersController;
    private BoardController boardController;

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
        startMonopolyGame(Arrays.asList(new String[]{"Jasper", "Sara"}));
        initializeBoard();
    }

    private void initializeBoard() {
        String[] boardComponentMessageResources = monopolyGameService.getMonopolyBoardSpacesMessageResources();
        boardController.initializeBoard(boardComponentMessageResources);
    }

    public void startMonopolyGame(List<String> playerNames) {
        monopolyGameService.startMonopolyGame(playerNames);
        monopolyGameView.showChildViews();
    }
}
