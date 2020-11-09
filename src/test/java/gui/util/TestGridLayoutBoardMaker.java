package gui.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGridLayoutBoardMaker {
    private final List<Integer> LEGAL_BOARD_SIZES = Arrays.asList(4, 16, 100, 172, 836);
    private final List<Integer> ILLEGAL_BOARD_SIZES = Arrays.asList(1, 3, 11, 18, 99, 15);

    private final int FOUR_BOARD_COMPONENTS = 4;
    private final int TWELVE_BOARD_COMPONENTS = 12;
    private final int SIXTEEN_BOARD_COMPONENTS = 16;
    private final int FORTY_BOARD_COMPONENTS = 40;

    private final Integer[] FOUR_BOARD_COMPONENTS_OUTCOME = new Integer[]{
            2, 3,   // First row.
            1, 0    // Second row.
    };
    private final Integer[] TWELVE_BOARD_COMPONENTS_OUTCOME = new Integer[]{
            6, 7, 8, 9,         // First row.
            5, null, null, 10,  // Second row.
            4, null, null, 11,  // Third row.
            3, 2, 1, 0          // Fourth row.

    };
    private final Integer[] SIXTEEN_BOARD_COMPONENTS_OUTCOME = new Integer[]{
            8, 9, 10, 11, 12,           // First row.
            7, null, null, null, 13,    // Second row.
            6, null, null, null, 14,    // Third row.
            5, null, null, null, 15,    // Fourth row.
            4, 3, 2, 1, 0               // Fifth row.
    };
    private final Integer[] FORTY_BOARD_COMPONENTS_OUTCOME = new Integer[]{
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,         // First row.
            19, null, null, null , null, null, null, null, null, null, 31,  // Second row.
            18, null, null, null , null, null, null, null, null, null, 32,  // Third row.
            17, null, null, null , null, null, null, null, null, null, 33,  // Fourth row.
            16, null, null, null , null, null, null, null, null, null, 34,  // Fifth row.
            15, null, null, null , null, null, null, null, null, null, 35,  // Sixth row.
            14, null, null, null , null, null, null, null, null, null, 36,  // Seventh row.
            13, null, null, null , null, null, null, null, null, null, 37,  // Eight row.
            12, null, null, null , null, null, null, null, null, null, 38,  // Ninth row.
            11, null, null, null , null, null, null, null, null, null, 39,  // Tenth row.
            10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0                                // Eleventh row.

    };

    private GridLayoutBoardMaker gridLayoutBoardMaker;
    private String[] gridLayoutBoard;

    @Test
    void testCanMakeBoardsWithLegalBoardSizes() {
        for (Integer integer : LEGAL_BOARD_SIZES) {
            String[] boardComponents = makeStringArray(integer);
            new GridLayoutBoardMaker(boardComponents);
        }
    }

    @Test
    void cannotMakeBoardWithIllegalBoardSizes() {
        for (Integer integer : ILLEGAL_BOARD_SIZES) {
            String[] boardComponents = makeStringArray(integer);
            assertThrows(RuntimeException.class, () -> new GridLayoutBoardMaker(boardComponents));
        }
    }

    @Test
    void testForFourBoardComponents() {
        makeGridLayoutBoard(FOUR_BOARD_COMPONENTS);
        String[] expectedOutcome = convertToStringArray(FOUR_BOARD_COMPONENTS_OUTCOME);
        assertTrue(gridLayoutBoardMatch(expectedOutcome));
    }

    @Test
    void testForTwelveBoardComponents() {
        makeGridLayoutBoard(TWELVE_BOARD_COMPONENTS);
        String[] expectedOutcome = convertToStringArray(TWELVE_BOARD_COMPONENTS_OUTCOME);
        assertTrue(gridLayoutBoardMatch(expectedOutcome));
    }

    @Test
    void testForSixteenBoardComponents() {
        makeGridLayoutBoard(SIXTEEN_BOARD_COMPONENTS);
        String[] expectedOutcome = convertToStringArray(SIXTEEN_BOARD_COMPONENTS_OUTCOME);
        assertTrue(gridLayoutBoardMatch(expectedOutcome));
    }

    @Test
    void testForFortyBoardComponents() {
        makeGridLayoutBoard(FORTY_BOARD_COMPONENTS);
        String[] expectedOutcome = convertToStringArray(FORTY_BOARD_COMPONENTS_OUTCOME);
        assertTrue(gridLayoutBoardMatch(expectedOutcome));
    }

    private void makeGridLayoutBoard(int size) {
        String[] boardComponents = makeStringArray(size);
        gridLayoutBoardMaker = new GridLayoutBoardMaker(boardComponents);
        gridLayoutBoard = gridLayoutBoardMaker.makeBoard();
    }

    private String[] makeStringArray(int length) {
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = Integer.valueOf(i).toString();
        }
        return strings;
    }

    private String[] convertToStringArray(Integer[] integers) {
        String[] strings = new String[integers.length];
        for (int i = 0; i < integers.length; i++) {
            Integer integer = integers[i];
            strings[i] = integer == null ? null : integer.toString();
        }
        return strings;
    }

    public boolean gridLayoutBoardMatch(String [] expectedOutcome) {
        return Arrays.equals(gridLayoutBoard, expectedOutcome);
    }
}
