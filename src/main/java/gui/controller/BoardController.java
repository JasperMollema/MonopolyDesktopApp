package gui.controller;

import gui.util.BoardCoordinateCalculator;
import gui.view.BoardView;

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

    public void initializeBoard(String[] boardComponentMessageResources) {
        boardView.fillBoardComponents(boardComponentMessageResources);
        int numberOfBoardComponents = boardComponentMessageResources.length;
        drawBoard(numberOfBoardComponents);
    }

    private void drawBoard(int numberOfBoardComponents) {
        BoardCoordinateCalculator boardCoordinateCalculator = new BoardCoordinateCalculator(numberOfBoardComponents);
        for (int i = 0; i < numberOfBoardComponents; i++) {
            int boardSpaceNumber = i + 1;
            int gridX = boardCoordinateCalculator.getXCoordinate(boardSpaceNumber);
            int gridY = boardCoordinateCalculator.getYCoordinate(boardSpaceNumber);
            boardView.addBoardComponent(i, gridX, gridY);
        }
    }
}
