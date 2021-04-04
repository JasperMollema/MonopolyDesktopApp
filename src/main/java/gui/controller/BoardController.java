package gui.controller;

import gui.util.GridLayoutBoardMaker;
import gui.view.BoardView;
import valueObjects.BoardSpaceValueObject;
import valueObjects.PlayerValueObject;

import java.util.List;

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

    public void initializeBoard(List<BoardSpaceValueObject> boardSpaceValueObjects, List<PlayerValueObject> playerValueObjects) {
        GridLayoutBoardMaker gridLayoutBoardMaker = new GridLayoutBoardMaker(boardSpaceValueObjects);
        boardView.fillBoardComponents(gridLayoutBoardMaker.makeBoard(), playerValueObjects);
    }

    public void emptyBoard() {
        boardView.emptyBoard();
    }

    public void setPlayerOnBoardComponent(String playerName, Integer boardComponentIdentifier) {
        boardView.setPlayerOnBoardComponent(playerName, boardComponentIdentifier);
    }

    public void removePlayerFromBoardComponent(String playerName, Integer boardComponentIdentifier) {
        boardView.removePlayerFromBoardComponent(playerName, boardComponentIdentifier);
    }
}
