package gui.controller;

import gui.util.GridLayoutBoardMaker;
import gui.view.BoardView;

import java.awt.*;
import java.util.Map;

public class BoardController extends AbstractController {
    private BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;
    }

    @Override
    public String getControllerName() {
        return "BoardController";
    }

    @Override
    public void startController() {

    }

    public void initializeBoard(String[] boardComponentMessageResources, Map<String, Color> playerColors) {
        GridLayoutBoardMaker gridLayoutBoardMaker = new GridLayoutBoardMaker(null);
        boardView.fillBoardComponents(null, playerColors);
    }

    public void setPlayerOnBoardComponent(String playerName, Integer boardComponentIdentifier) {
        boardView.setPlayerOnBoardComponent(playerName, boardComponentIdentifier);
    }
}
