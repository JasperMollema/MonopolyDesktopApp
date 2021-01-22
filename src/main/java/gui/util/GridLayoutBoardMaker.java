package gui.util;

import valueObjects.BoardSpaceValueObject;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutBoardMaker {
    private List<BoardSpaceValueObject> boardSpaceValueObjects;
    private int squareSize;
    private int boardSize;
    private int totalBoardSpaceValueObjects;
    private List<BoardSpaceValueObject> newBoardSpaceValueObjectList;
    private BoardCoordinateCalculator boardCoordinateCalculator;

    public GridLayoutBoardMaker(List<BoardSpaceValueObject> boardSpaceValueObjects) {
        if (boardSize % 4 != 0) {
            throw new RuntimeException("GridLayoutBoardMaker: Try to make board with illegal board size.");
        }
        this.boardSpaceValueObjects = boardSpaceValueObjects;
        boardSize = boardSpaceValueObjects.size();
        squareSize = boardSize/4 +1;
        totalBoardSpaceValueObjects = squareSize * squareSize;
        initializeNewBoardSpaceValueObjectList(totalBoardSpaceValueObjects);
        boardCoordinateCalculator = new BoardCoordinateCalculator(boardSize);
    }

    private void initializeNewBoardSpaceValueObjectList(int size) {
        newBoardSpaceValueObjectList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newBoardSpaceValueObjectList.add(null);
        }
    }

    public List<BoardSpaceValueObject> makeBoard() {
        for (int i = 0; i < boardSize; i++) {
            BoardSpaceValueObject boardSpaceValueObject = boardSpaceValueObjects.get(i);
            int rowNr = boardCoordinateCalculator.getYCoordinate(i + 1);
            int rowPosition = boardCoordinateCalculator.getXCoordinate(i + 1);
            addBoardComponent(boardSpaceValueObject, rowNr, rowPosition);
        }
        return newBoardSpaceValueObjectList;
    }

    private void addBoardComponent(BoardSpaceValueObject boardSpaceValueObject, int rowNumber, int rowPosition) {
        int firstIndexOfRow = determineFirstIndexOfRow(rowNumber);
        int index = firstIndexOfRow + rowPosition - 1;
        newBoardSpaceValueObjectList.set(index, boardSpaceValueObject);
    }

    private int determineFirstIndexOfRow(int rowNumber) {
        return rowNumber * squareSize - squareSize;
    }
}
