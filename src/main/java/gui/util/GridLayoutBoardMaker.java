package gui.util;

public class GridLayoutBoardMaker {
    private String[] boardComponents;
    private int squareSize;
    private int boardSize;
    private int totalComponents;
    private String[] newBoardArray;
    private BoardCoordinateCalculator boardCoordinateCalculator;
    public GridLayoutBoardMaker(String[] boardComponents) {
        if (boardSize % 4 != 0) {
            throw new RuntimeException("GridLayoutBoardMaker: Try to make board with illegal number of boardsizes");
        }
        this.boardComponents = boardComponents;
        boardSize = boardComponents.length;
        squareSize = boardSize/4 +1;
        totalComponents = squareSize * squareSize;
        newBoardArray = new String[totalComponents];
        boardCoordinateCalculator = new BoardCoordinateCalculator(boardSize);
    }

    public String[] makeBoard() {
        for (int i = 0; i < boardSize; i++) {
            String boardComponent = boardComponents[i];
            int rowNr = boardCoordinateCalculator.getYCoordinate(i + 1);
            int rowPosition = boardCoordinateCalculator.getXCoordinate(i + 1);
            addBoardComponent(boardComponent, rowNr, rowPosition);
        }
        return newBoardArray;
    }

    private void addBoardComponent(String boardComponent, int rowNumber, int rowPosition) {
        int firstIndexOfRow = determineFirstIndexOfRow(rowNumber);
        int index = firstIndexOfRow + rowPosition - 1;
        newBoardArray[index] = boardComponent;
    }

    private int determineFirstIndexOfRow(int rowNumber) {
        return rowNumber * squareSize - squareSize;
    }
}
