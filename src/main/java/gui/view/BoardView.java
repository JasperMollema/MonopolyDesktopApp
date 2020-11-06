package gui.view;

import gui.component.BoardComponent;

import java.awt.*;

public class BoardView extends AbstractGridBagView {
    private BoardComponent[] boardComponents;

    private BoardComponent chance = new BoardComponent("Kans");
    private BoardComponent fonds = new BoardComponent("Algemeen fonds");

    public BoardView() {

        setVisible(true);

        initializeGridBagConstraints();
        addComponentToGridBagConstraints(fonds, SEVENTH_ROW, FOURTH_COLUMN);
        addComponentToGridBagConstraints(chance, FOURTH_ROW, SEVENTH_COLUMN);

        setBackground(Color.BLACK);
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

    public void setPlayerOnStart(String playerName) {
        boardComponents[0].addPlayer(playerName);
    }

    @Override
    public void initializeView() {

    }

    @Override
    public String getViewName() {
        return "BoardView";
    }
}
