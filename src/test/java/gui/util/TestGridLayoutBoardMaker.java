package gui.util;

import org.junit.jupiter.api.Test;
import valueObjects.BoardSpaceValueObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGridLayoutBoardMaker {
    private final List<Integer> LEGAL_BOARD_SIZES = Arrays.asList(4, 16, 100, 172, 836);
    private final List<Integer> ILLEGAL_BOARD_SIZES = Arrays.asList(1, 3, 11, 18, 99, 15);

    private final int FOUR_BOARD_COMPONENTS = 4;
    private final int TWELVE_BOARD_COMPONENTS = 12;
    private final int SIXTEEN_BOARD_COMPONENTS = 16;
    private final int FORTY_BOARD_COMPONENTS = 40;

    private final Integer[] FOUR_BOARD_COMPONENTS_ARRAY = new Integer[]{
            2, 3,   // First row.
            1, 0    // Second row.
    };

    private final Integer[] TWELVE_BOARD_COMPONENTS_ARRAY = new Integer[]{
            6, 7, 8, 9,         // First row.
            5, null, null, 10,  // Second row.
            4, null, null, 11,  // Third row.
            3, 2, 1, 0          // Fourth row.

    };
    private final Integer[] SIXTEEN_BOARD_COMPONENTS_ARRAY = new Integer[]{
            8, 9, 10, 11, 12,           // First row.
            7, null, null, null, 13,    // Second row.
            6, null, null, null, 14,    // Third row.
            5, null, null, null, 15,    // Fourth row.
            4, 3, 2, 1, 0               // Fifth row.
    };
    private final Integer[] FORTY_BOARD_COMPONENTS_ARRAY = new Integer[]{
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

    private final List<MockBoardSpaceValueObject> FOUR_BOARD_COMPONENTS_EXPECTED_OUTCOME;
    private final List<MockBoardSpaceValueObject> TWELVE_BOARD_COMPONENTS_EXPECTED_OUTCOME;
    private final List<MockBoardSpaceValueObject> SIXTEEN_BOARD_COMPONENTS_EXPECTED_OUTCOME;
    private final List<MockBoardSpaceValueObject> FORTY_BOARD_COMPONENTS_EXPECTED_OUTCOME;

    private GridLayoutBoardMaker gridLayoutBoardMaker;
    private String[] gridLayoutBoard;

    public TestGridLayoutBoardMaker() {
        FOUR_BOARD_COMPONENTS_EXPECTED_OUTCOME = makeMockBoardSpaceList(FOUR_BOARD_COMPONENTS_ARRAY);
        TWELVE_BOARD_COMPONENTS_EXPECTED_OUTCOME = makeMockBoardSpaceList(TWELVE_BOARD_COMPONENTS_ARRAY);
        SIXTEEN_BOARD_COMPONENTS_EXPECTED_OUTCOME = makeMockBoardSpaceList(SIXTEEN_BOARD_COMPONENTS_ARRAY);
        FORTY_BOARD_COMPONENTS_EXPECTED_OUTCOME = makeMockBoardSpaceList(FORTY_BOARD_COMPONENTS_ARRAY);
    }

    private List<MockBoardSpaceValueObject> makeMockBoardSpaceList(Integer[] boardIdentifiers) {
        List<MockBoardSpaceValueObject> mockBoardSpaceValueObjects = new ArrayList<>(boardIdentifiers.length);
        for (Integer identifier : boardIdentifiers) {
            mockBoardSpaceValueObjects.add(new MockBoardSpaceValueObject(identifier));
        }
        return mockBoardSpaceValueObjects;
    }

    @Test
    void testCanMakeBoardsWithLegalBoardSizes() {
        for (Integer integer : LEGAL_BOARD_SIZES) {
            List<BoardSpaceValueObject> boardSpaceValueObjects = makeBoardSpaceValueObjectList(integer);
            new GridLayoutBoardMaker(boardSpaceValueObjects);
        }
    }

    @Test
    void cannotMakeBoardWithIllegalBoardSizes() {
        for (Integer integer : ILLEGAL_BOARD_SIZES) {
            List<BoardSpaceValueObject> boardSpaceValueObjects = makeBoardSpaceValueObjectList(integer);
            assertThrows(RuntimeException.class, () -> new GridLayoutBoardMaker(boardSpaceValueObjects));
        }
    }

    @Test
    void testForFourBoardComponents() {
        List<MockBoardSpaceValueObject> actualOutcome = makeGridLayoutBoard(FOUR_BOARD_COMPONENTS);
        assertEquals(FOUR_BOARD_COMPONENTS_EXPECTED_OUTCOME, actualOutcome);
    }

    @Test
    void testForTwelveBoardComponents() {
        List<MockBoardSpaceValueObject> actualOutcome = makeGridLayoutBoard(TWELVE_BOARD_COMPONENTS);
        assertEquals(TWELVE_BOARD_COMPONENTS_EXPECTED_OUTCOME, actualOutcome);
    }

    @Test
    void testForSixteenBoardComponents() {
        List<MockBoardSpaceValueObject> actualOutcome = makeGridLayoutBoard(SIXTEEN_BOARD_COMPONENTS);
        assertEquals(SIXTEEN_BOARD_COMPONENTS_EXPECTED_OUTCOME, actualOutcome);
    }

    @Test
    void testForFortyBoardComponents() {
        List<MockBoardSpaceValueObject> actualOutcome = makeGridLayoutBoard(FORTY_BOARD_COMPONENTS);
        assertEquals(FORTY_BOARD_COMPONENTS_EXPECTED_OUTCOME, actualOutcome);
    }

    private List<MockBoardSpaceValueObject> makeGridLayoutBoard(int size) {
        gridLayoutBoardMaker = new GridLayoutBoardMaker(makeBoardSpaceValueObjectList(size));
        List<BoardSpaceValueObject> boardSpaceValueObjects = gridLayoutBoardMaker.makeBoard();
        List<MockBoardSpaceValueObject> mockBoardSpaceValueObjects = new ArrayList<>();
        for (BoardSpaceValueObject boardSpaceValueObject : boardSpaceValueObjects) {
            mockBoardSpaceValueObjects.add((MockBoardSpaceValueObject) boardSpaceValueObject);
        }
        return mockBoardSpaceValueObjects;
    }

    private List<BoardSpaceValueObject> makeBoardSpaceValueObjectList(int size) {
        List<BoardSpaceValueObject> boardSpaceValueObjects = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            boardSpaceValueObjects.add(new MockBoardSpaceValueObject(i));
        }
        return boardSpaceValueObjects;
    }

    private class MockBoardSpaceValueObject extends BoardSpaceValueObject {
        public MockBoardSpaceValueObject(Integer identifier) {
            this.identifier = identifier;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return true;
            }
            MockBoardSpaceValueObject mockBoardSpaceValueObject = (MockBoardSpaceValueObject) obj;
            return mockBoardSpaceValueObject.identifier == this.identifier;
        }
    }
}
