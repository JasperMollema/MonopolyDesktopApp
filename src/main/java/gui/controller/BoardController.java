package gui.controller;

import gui.util.GridLayoutBoardMaker;
import gui.view.BoardView;
import valueObjects.BoardSpaceValueObject;

import java.awt.*;
import java.util.List;
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

    public void initializeBoard(List<BoardSpaceValueObject> boardSpaceValueObjects, Map<String, Color> playerColors) {
        GridLayoutBoardMaker gridLayoutBoardMaker = new GridLayoutBoardMaker(boardSpaceValueObjects);
        boardView.fillBoardComponents(gridLayoutBoardMaker.makeBoard(), playerColors);
    }

    public void setPlayerOnBoardComponent(String playerName, Integer boardComponentIdentifier) {
        boardView.setPlayerOnBoardComponent(playerName, boardComponentIdentifier);
    }

    public void removePlayerFromBoardComponent(String playerName, Integer boardComponentIdentifier) {
        boardView.removePlayerFromBoardComponent(playerName, boardComponentIdentifier);
    }
}
