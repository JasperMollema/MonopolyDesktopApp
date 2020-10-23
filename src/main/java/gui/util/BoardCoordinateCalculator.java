package gui.util;

import java.util.ArrayList;
import java.util.List;

public class BoardCoordinateCalculator {
    private int boardSize;
    private int rowSize;
    private int boardSpaceNumberBottomLeft;
    private int boardSpaceNumberTopLeft;
    private int boardSpaceNumberTopRight;
    List<Integer> bottomRowBoardSpaces;
    List<Integer> leftRowBoardSpaces;
    List<Integer> topRowBoardSpaces;
    List<Integer> rightRowBoardSpaces;
    List<Integer> cornerBoardSpaces;
    private int bottomRowYCoordinate;
    private int rightRowXCoordinate;

    private final int BOARD_SPACE_NUMBER_BOTTOM_RIGHT = 1;
    private final int LEFT_ROW_X_COORDINATE = 1;
    private final int TOP_ROW_Y_COORDINATE = 1;
    private int NUMBER_OF_ROWS = 4;

    public BoardCoordinateCalculator(int boardSize) {
        if (boardSizeIsNotAllowed(boardSize)) {
            throw new RuntimeException("BoardCoordinateCalculator: Boardsize should be a multiplier of four.");
        }
        this.boardSize = boardSize;
        rowSize = boardSize / NUMBER_OF_ROWS -1;
        bottomRowBoardSpaces = new ArrayList<>();
        leftRowBoardSpaces = new ArrayList<>();
        topRowBoardSpaces = new ArrayList<>();
        rightRowBoardSpaces = new ArrayList<>();
        cornerBoardSpaces = new ArrayList<>();
        bottomRowYCoordinate = boardSize / 4 + 1;
        rightRowXCoordinate = boardSize / 4 + 1;
        calculateBoardSpaceNumbersCorners();
        fillBoardSpaceCorners();
        fillBoardSpaceRows();
    }

    private boolean boardSizeIsNotAllowed(int boardSize) {
        return !(boardSize > 0 && boardSize % 4 == 0);
    }

    private void calculateBoardSpaceNumbersCorners() {
        boardSpaceNumberBottomLeft = BOARD_SPACE_NUMBER_BOTTOM_RIGHT + rowSize + 1;
        boardSpaceNumberTopLeft = boardSpaceNumberBottomLeft + rowSize + 1;
        boardSpaceNumberTopRight = boardSpaceNumberTopLeft + rowSize + 1;
    }

    private void fillBoardSpaceCorners() {
        cornerBoardSpaces.add(BOARD_SPACE_NUMBER_BOTTOM_RIGHT);
        cornerBoardSpaces.add(boardSpaceNumberBottomLeft);
        cornerBoardSpaces.add(boardSpaceNumberTopLeft);
        cornerBoardSpaces.add(boardSpaceNumberTopRight);
    }

    private void fillBoardSpaceRows() {
        for (int i = 2; i <= boardSize; i++) {
            if (belongsToBottomRow(i)) {
                bottomRowBoardSpaces.add(i);
            }

            if (belongsToLeftRow(i)) {
                leftRowBoardSpaces.add(i);
            }

            if (belongsToTopRow(i)) {
                topRowBoardSpaces.add(i);
            }

            if (belongsToRightRow(i)) {
                rightRowBoardSpaces.add(i);
            }
        }
    }

    private boolean belongsToBottomRow(int boardSpaceNr) {
        return boardSpaceNr > BOARD_SPACE_NUMBER_BOTTOM_RIGHT && boardSpaceNr < boardSpaceNumberBottomLeft;
    }

    private boolean belongsToLeftRow(int boardSpaceNr) {
        return boardSpaceNr > boardSpaceNumberBottomLeft && boardSpaceNr < boardSpaceNumberTopLeft;
    }

    private boolean belongsToTopRow(int boardSpaceNr) {
        return boardSpaceNr > boardSpaceNumberTopLeft && boardSpaceNr < boardSpaceNumberTopRight;
    }

    private boolean belongsToRightRow(int boardSpaceNr) {
        return boardSpaceNr > boardSpaceNumberTopRight && boardSpaceNr <= boardSize;
    }

    public int getXCoordinate(int boardSpaceNr) {

        if (cornerBoardSpaces.contains(boardSpaceNr)) {
            return determineXForCorner(boardSpaceNr);
        }

        if (bottomRowBoardSpaces.contains(boardSpaceNr)) {
            return determineXForBottomRow(boardSpaceNr);
        }

        if (leftRowBoardSpaces.contains(boardSpaceNr)) {
            return LEFT_ROW_X_COORDINATE;
        }

        if (topRowBoardSpaces.contains(boardSpaceNr)) {
            return determineXForTopRow(boardSpaceNr);
        }

        if (rightRowBoardSpaces.contains(boardSpaceNr)) {
            return rightRowXCoordinate;
        }

        return -1;
    }

    private int determineXForCorner(int boardSpaceNr) {
        if (isInRightCorner(boardSpaceNr)) {
            return rightRowXCoordinate;
        }

        else return LEFT_ROW_X_COORDINATE;
    }

    private boolean isInRightCorner(int boardSpaceNr) {
        return boardSpaceNr == BOARD_SPACE_NUMBER_BOTTOM_RIGHT || boardSpaceNr == boardSpaceNumberTopRight;
    }

    private int determineXForBottomRow(int boardSpaceNr) {
        return rowSize - boardSpaceNr + 3;
    }

    private int determineXForTopRow(int boardSpaceNr) {
        return boardSpaceNr - boardSize/2;
    }

    public int getYCoordinate(int boardSpaceNr) {
        if (cornerBoardSpaces.contains(boardSpaceNr)) {
            return determineYForCorner(boardSpaceNr);
        }

        if (bottomRowBoardSpaces.contains(boardSpaceNr)) {
            return bottomRowYCoordinate;
        }

        if (leftRowBoardSpaces.contains(boardSpaceNr)) {
            return determineYForLeftRow(boardSpaceNr);
        }

        if (topRowBoardSpaces.contains(boardSpaceNr)) {
            return TOP_ROW_Y_COORDINATE;
        }

        if (rightRowBoardSpaces.contains(boardSpaceNr)) {
            return determineYForRightRow(boardSpaceNr);
        }

        return -1;
    }

    private int determineYForCorner(int boardSpaceNr) {
        if (isInBottomCorner(boardSpaceNr)) {
            return bottomRowYCoordinate;
        }
        else return TOP_ROW_Y_COORDINATE;
    }

    private boolean isInBottomCorner(int boardSpaceNr) {
        return boardSpaceNr == BOARD_SPACE_NUMBER_BOTTOM_RIGHT || boardSpaceNr == boardSpaceNumberBottomLeft;
    }

    private int determineYForLeftRow(int boardSpaceNr) {
        return ((boardSize / 4) + 1) * 2 - boardSpaceNr;
    }

    private int determineYForRightRow(int boardSpaceNr) {

        return boardSpaceNr - (boardSize/4)*3;
    }

}
