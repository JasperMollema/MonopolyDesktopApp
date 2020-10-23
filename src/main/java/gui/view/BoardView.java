package gui.view;

import gui.component.BoardComponent;

import java.awt.*;

public class BoardView extends AbstractGridBagView {
    private BoardComponent[] boardComponents;

    private BoardComponent[] boardComponentsSouth = new BoardComponent[]{
            new BoardComponent("Start"),
            new BoardComponent("Dorp"),
            new BoardComponent("Kans"),
            new BoardComponent("Brink"),
            new BoardComponent("Belasting"),
            new BoardComponent("Station Zuid"),
            new BoardComponent("Ketelstraat"),
            new BoardComponent("SteenStraat"),
            new BoardComponent("Algemeen Fonds"),
            new BoardComponent("VelperPlein")
    };

    private BoardComponent[] boardComponentsWest = new BoardComponent[]{
            new BoardComponent("Start"),
            new BoardComponent("Dorp"),
            new BoardComponent("Kans"),
            new BoardComponent("Brink"),
            new BoardComponent("Belasting"),
            new BoardComponent("Station Zuid"),
            new BoardComponent("Ketelstraat"),
            new BoardComponent("SteenStraat"),
            new BoardComponent("Algemeen Fonds"),
            new BoardComponent("VelperPlein")
    };

    private BoardComponent[] boardComponentsNorth = new BoardComponent[]{
            new BoardComponent("Start"),
            new BoardComponent("Dorp"),
            new BoardComponent("Kans"),
            new BoardComponent("Brink"),
            new BoardComponent("Belasting"),
            new BoardComponent("Station Zuid"),
            new BoardComponent("Ketelstraat"),
            new BoardComponent("SteenStraat"),
            new BoardComponent("Algemeen Fonds"),
            new BoardComponent("VelperPlein")
    };

    private BoardComponent[] boardComponentsEast = new BoardComponent[]{
            new BoardComponent("Start"),
            new BoardComponent("Dorp"),
            new BoardComponent("Kans"),
            new BoardComponent("Brink"),
            new BoardComponent("Belasting"),
            new BoardComponent("Station Zuid"),
            new BoardComponent("Ketelstraat"),
            new BoardComponent("SteenStraat"),
            new BoardComponent("Algemeen Fonds"),
            new BoardComponent("VelperPlein")
    };

    private BoardComponent chance = new BoardComponent("Kans");
    private BoardComponent fonds = new BoardComponent("Algemeen fonds");

    public BoardView() {

        setVisible(true);

        initializeGridBagConstraints();
        layOutSouthBoardComponents();
        layOutWestBoardComponents();
        layOutEastBoardComponents();
        layOutNorthBoardComponents();
        addComponentToGridBagConstraints(fonds, SEVENTH_ROW, FOURTH_COLUMN);
        addComponentToGridBagConstraints(chance, FOURTH_ROW, SEVENTH_COLUMN);

        setBackground(Color.BLACK);
    }

    private void layOutSouthBoardComponents() {
        // Leg op twaalfde rij, en van 11 tot en met 2e column
        int column = 11;
        for (int i = 0; i < boardComponentsSouth.length; i++) {
            BoardComponent boardComponent = boardComponentsSouth[i];
            add(boardComponent);
            boardComponent.setVisible(true);
            addComponentToGridBagConstraints(boardComponent, TWELFTH_ROW, column);
            column--;
        }
    }

    private void layOutWestBoardComponents() {
        // Leg op 1e column, en van 2 tot en met 11e rij
        int row = 2;
        for (int i = 0; i < boardComponentsWest.length; i++) {
            BoardComponent boardComponent = boardComponentsWest[i];
            add(boardComponent);
            boardComponent.setVisible(true);
            addComponentToGridBagConstraints(boardComponent, row, FIRST_COLUMN);
            row++;
        }
    }

    private void layOutNorthBoardComponents() {
        // Leg op 1e rij, en van 2e tot en met 11e column
        int column = 2;
        for (int i = 0; i < boardComponentsNorth.length; i++) {
            BoardComponent boardComponent = boardComponentsNorth[i];
            add(boardComponent);
            boardComponent.setVisible(true);
            addComponentToGridBagConstraints(boardComponent, FIRST_ROW, column);
            column++;
        }
    }

    private void layOutEastBoardComponents() {
        // Leg op 12e column, en van 2 tot en met 11e rij
        int row = 2;
        for (int i = 0; i < boardComponentsEast.length; i++) {
            BoardComponent boardComponent = boardComponentsEast[i];
            add(boardComponent);
            boardComponent.setVisible(true);
            addComponentToGridBagConstraints(boardComponent, row, TWELFTH_COLUMN);
            row++;
        }
    }

    public void fillBoardComponents(String[] boardComponentMessageResources) {
        int numberOfBoardComponents = boardComponentMessageResources.length;
        boardComponents = new BoardComponent[numberOfBoardComponents];
        for (int i = 0; i < numberOfBoardComponents; i++) {
            String boardComponentName = getMessage(boardComponentMessageResources[i]);
            boardComponents[i] = new BoardComponent(boardComponentName);
        }
    }

    public void addBoardComponent(int boardComponentIndex, int gridX, int gridY) {
        BoardComponent boardComponent = boardComponents[boardComponentIndex];
        addComponentToGridBagConstraints(boardComponent, gridX, gridY);
    }

    @Override
    public void initializeView() {

    }

    @Override
    public String getViewName() {
        return "BoardView";
    }
}
