package gui.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBoardCoordinateCalculator {
    private BoardCoordinateCalculator boardCoordinateCalculator;

    private final int BOARD_SIZE = 40;
    private final Integer[] BOARD_SIZES_THAT_CANNOT_BE_DIVIDED_BY_FOUR = new Integer[]{3, 11, 18, 0, 99, 15};
    private final Integer[] BOARD_SIZES_THAT_CAN_BE_DIVIDED_BY_FOUR = new Integer[]{4, 16, 44, 60, 100};

    private final int FOUR_SQUARES = 4;
    private final int SIXTEEN_SQUARES = 16;
    private final int FORTY_SQUARES = 40;

    private final int[] BOTTOM_ROW_SPACES_FOUR_SQUARE_BOARD = new int[]{1, 2};
    private final int[] LEFT_ROW_SPACES_FOUR_SQUARE_BOARD = new int[]{2, 3};
    private final int[] TOP_ROW_SPACES_FOUR_SQUARE_BOARD = new int[]{3, 4};
    private final int[] RIGHT_ROW_SPACES_FOUR_SQUARE_BOARD = new int[]{4, 1};

    private final int[] BOTTOM_ROW_SPACES_SIXTEEN_SQUARE_BOARD = new int[]{1, 2, 3, 4, 5};
    private final int[] LEFT_ROW_SPACES_SIXTEEN_SQUARE_BOARD = new int[]{5, 6, 7, 8, 9,};
    private final int[] TOP_ROW_SPACES_SIXTEEN_SQUARE_BOARD = new int[]{9, 10, 11, 12};
    private final int[] RIGHT_ROW_SPACES_SIXTEEN_SQUARE_BOARD = new int[]{13, 14, 15, 16, 1};

    private final int[] BOTTOM_ROW_SPACES_FORTY_SQUARE_BOARD = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private final int[] LEFT_ROW_SPACES_FORTY_SQUARE_BOARD = new int[]{11, 12, 13, 14, 15, 16, 17 ,18, 19, 20, 21};
    private final int[] TOP_ROW_SPACES_FORTY_SQUARE_BOARD = new int[]{21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private final int[] RIGHT_ROW_SPACES_FORTY_SQUARE_BOARD = new int[]{31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 1};

    private final int MIN_COORDINATE = 1;
    private final int MAX_COORDINATE_FOUR_SQUARE_BOARD = 2;
    private final int MAX_COORDINATE_SIXTEEN_SQUARE_BOARD = 5;
    private final int MAX_COORDINATE_FORTY_SQUARE_BOARD = 11;

    @Test
    void cannotMakeBoardCoordinateCalculatorWithNegativeOrZeroBoardSize() {
        assertThrows(RuntimeException.class, () -> new BoardCoordinateCalculator(-4));
        assertThrows(RuntimeException.class, () -> new BoardCoordinateCalculator(0));
    }

    @Test
    void cannotMakeBoardCoordinateCalculatorWithBoardSizesThatCannotBeDividedByFour() {
        List<Integer> illegalBoardSizes = Arrays.asList(BOARD_SIZES_THAT_CANNOT_BE_DIVIDED_BY_FOUR);
        for (Integer boardSize : illegalBoardSizes) {
            assertThrows(RuntimeException.class, () -> new BoardCoordinateCalculator(boardSize));
        }
    }

    @Test
    void testCoordinatesBottomRow4SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FOUR_SQUARES);
        int xCoordinate = MAX_COORDINATE_FOUR_SQUARE_BOARD;
        for (int i = 0; i < BOTTOM_ROW_SPACES_FOUR_SQUARE_BOARD.length; i++) {
            int boardSpace = BOTTOM_ROW_SPACES_FOUR_SQUARE_BOARD[i];
            assertEquals(xCoordinate, actualXCoordinate(boardSpace));
            assertEquals(MAX_COORDINATE_FOUR_SQUARE_BOARD, actualYCoordinate(boardSpace));
            xCoordinate--;
        }
    }

    @Test
    void testCoordinatesLeftRow4SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FOUR_SQUARES);
        int yCoordinate = MAX_COORDINATE_FOUR_SQUARE_BOARD;
        for (int i = 0; i < LEFT_ROW_SPACES_FOUR_SQUARE_BOARD.length; i++) {
            int boardSpace = LEFT_ROW_SPACES_FOUR_SQUARE_BOARD[i];
            assertEquals(MIN_COORDINATE, actualXCoordinate(boardSpace));
            assertEquals(yCoordinate, actualYCoordinate(boardSpace));
            yCoordinate--;
        }
    }

    @Test
    void testCoordinatesTopRow4SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FOUR_SQUARES);
        int xCoordinate = MIN_COORDINATE;
        for (int i = 0; i < TOP_ROW_SPACES_FOUR_SQUARE_BOARD.length; i++) {
            int boardSpace = TOP_ROW_SPACES_FOUR_SQUARE_BOARD[i];
            assertEquals(xCoordinate, actualXCoordinate(boardSpace));
            assertEquals(MIN_COORDINATE, actualYCoordinate(boardSpace));
            xCoordinate++;
        }
    }

    @Test
    void testCoordinatesRightRow4SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FOUR_SQUARES);
        int yCoordinate = MIN_COORDINATE;
        for (int i = 0; i < RIGHT_ROW_SPACES_FOUR_SQUARE_BOARD.length; i++) {
            int boardSpace = RIGHT_ROW_SPACES_FOUR_SQUARE_BOARD[i];
            assertEquals(MAX_COORDINATE_FOUR_SQUARE_BOARD, actualXCoordinate(boardSpace));
            assertEquals(yCoordinate, actualYCoordinate(boardSpace));
            yCoordinate++;
        }
    }

    @Test
    void testCoordinatesBottomRow16SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(SIXTEEN_SQUARES);
        int xCoordinate = MAX_COORDINATE_SIXTEEN_SQUARE_BOARD;
        for (int i = 0; i < BOTTOM_ROW_SPACES_SIXTEEN_SQUARE_BOARD.length; i++) {
            int boardSpace = BOTTOM_ROW_SPACES_SIXTEEN_SQUARE_BOARD[i];
            assertEquals(xCoordinate, actualXCoordinate(boardSpace));
            assertEquals(MAX_COORDINATE_SIXTEEN_SQUARE_BOARD, actualYCoordinate(boardSpace));
            xCoordinate--;
        }
    }

    @Test
    void testCoordinatesLeftRow16SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(SIXTEEN_SQUARES);
        int yCoordinate = MAX_COORDINATE_SIXTEEN_SQUARE_BOARD;
        for (int i = 0; i < LEFT_ROW_SPACES_SIXTEEN_SQUARE_BOARD.length; i++) {
            int boardSpace = LEFT_ROW_SPACES_SIXTEEN_SQUARE_BOARD[i];
            assertEquals(MIN_COORDINATE, actualXCoordinate(boardSpace));
            assertEquals(yCoordinate, actualYCoordinate(boardSpace));
            yCoordinate--;
        }
    }

    @Test
    void testCoordinatesTopRow16SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(SIXTEEN_SQUARES);
        int xCoordinate = MIN_COORDINATE;
        for (int i = 0; i < TOP_ROW_SPACES_SIXTEEN_SQUARE_BOARD.length; i++) {
            int boardSpace = TOP_ROW_SPACES_SIXTEEN_SQUARE_BOARD[i];
            assertEquals(xCoordinate, actualXCoordinate(boardSpace));
            assertEquals(MIN_COORDINATE, actualYCoordinate(boardSpace));
            xCoordinate++;
        }
    }

    @Test
    void testCoordinatesRightRow16SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(SIXTEEN_SQUARES);
        int yCoordinate = MIN_COORDINATE;
        for (int i = 0; i < RIGHT_ROW_SPACES_SIXTEEN_SQUARE_BOARD.length; i++) {
            int boardSpace = RIGHT_ROW_SPACES_SIXTEEN_SQUARE_BOARD[i];
            assertEquals(MAX_COORDINATE_SIXTEEN_SQUARE_BOARD, actualXCoordinate(boardSpace));
            assertEquals(yCoordinate, actualYCoordinate(boardSpace));
            yCoordinate++;
        }
    }

    @Test
    void testCoordinatesBottomRow40SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FORTY_SQUARES);
        int xCoordinate = MAX_COORDINATE_FORTY_SQUARE_BOARD;
        for (int i = 0; i < BOTTOM_ROW_SPACES_FORTY_SQUARE_BOARD.length; i++) {
            int boardSpace = BOTTOM_ROW_SPACES_FORTY_SQUARE_BOARD[i];
            assertEquals(xCoordinate, actualXCoordinate(boardSpace));
            assertEquals(MAX_COORDINATE_FORTY_SQUARE_BOARD, actualYCoordinate(boardSpace));
            xCoordinate--;
        }
    }

    @Test
    void testCoordinatesLeftRow40SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FORTY_SQUARES);
        int yCoordinate = MAX_COORDINATE_FORTY_SQUARE_BOARD;
        for (int i = 0; i < LEFT_ROW_SPACES_FORTY_SQUARE_BOARD.length; i++) {
            int boardSpace = LEFT_ROW_SPACES_FORTY_SQUARE_BOARD[i];
            assertEquals(MIN_COORDINATE, actualXCoordinate(boardSpace));
            assertEquals(yCoordinate, actualYCoordinate(boardSpace));
            yCoordinate--;
        }
    }

    @Test
    void testCoordinatesTopRow40SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FORTY_SQUARES);
        int xCoordinate = MIN_COORDINATE;
        for (int i = 0; i < TOP_ROW_SPACES_FORTY_SQUARE_BOARD.length; i++) {
            int boardSpace = TOP_ROW_SPACES_FORTY_SQUARE_BOARD[i];
            assertEquals(xCoordinate, actualXCoordinate(boardSpace));
            assertEquals(MIN_COORDINATE, actualYCoordinate(boardSpace));
            xCoordinate++;
        }
    }

    @Test
    void testCoordinatesRightRow40SquareBoard() {
        boardCoordinateCalculator = new BoardCoordinateCalculator(FORTY_SQUARES);
        int yCoordinate = MIN_COORDINATE;
        for (int i = 0; i < RIGHT_ROW_SPACES_FORTY_SQUARE_BOARD.length; i++) {
            int boardSpace = RIGHT_ROW_SPACES_FORTY_SQUARE_BOARD[i];
            assertEquals(MAX_COORDINATE_FORTY_SQUARE_BOARD, actualXCoordinate(boardSpace));
            assertEquals(yCoordinate, actualYCoordinate(boardSpace));
            yCoordinate++;
        }
    }

    private int actualXCoordinate(int boardSpace) {
        return boardCoordinateCalculator.getXCoordinate(boardSpace);
    }

    private int actualYCoordinate(int boardSpace) {
        return boardCoordinateCalculator.getYCoordinate(boardSpace);
    }

    @Test
    void testCoordinatesForNonExistentBoardSpaces() {
        int nonExistentCoordinate = -1;
        boardCoordinateCalculator = new BoardCoordinateCalculator(FOUR_SQUARES);
        assertEquals(nonExistentCoordinate, boardCoordinateCalculator.getXCoordinate(-2));
        assertEquals(nonExistentCoordinate, boardCoordinateCalculator.getYCoordinate(-2));
        assertEquals(nonExistentCoordinate, boardCoordinateCalculator.getXCoordinate(42));
        assertEquals(nonExistentCoordinate, boardCoordinateCalculator.getYCoordinate(42));
    }
}
