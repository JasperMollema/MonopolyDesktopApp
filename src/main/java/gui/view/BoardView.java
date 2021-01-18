package gui.view;

import gui.component.BoardComponent;

import java.awt.*;
import java.util.Map;

public class BoardView extends AbstractView {
    private BoardComponent[] boardComponents;

    public BoardView() {
        setVisible(true);
        setLayout(new GridLayout(11,11));
        setBackground(Color.LIGHT_GRAY);
    }

    public void fillBoardComponents(String[] boardComponentsToBeFilled, Map<String, Color> playerColors) {
        int numberOfBoardComponents = boardComponentsToBeFilled.length;
        boardComponents = new BoardComponent[numberOfBoardComponents];
        for (int i = 0; i < numberOfBoardComponents; i++) {

            String boardComponentName = fillName(boardComponentsToBeFilled[i]);
            BoardComponent boardComponent = new BoardComponent(boardComponentName, playerColors);
            boardComponents[i] = boardComponent;
            add(boardComponent);
            boardComponent.setVisible(true);
            if (boardComponentName != null) {
                System.out.println("BoardView : Add " + boardComponentName + " to board.");
            }

        }
    }

    private String fillName(String messageResource) {
        return messageResource == null ? null : getMessage(messageResource);
    }

    public void setPlayerOnStart(String playerName) {
    }

    @Override
    public void initializeView() {

    }

    @Override
    public String getViewName() {
        return "BoardView";
    }
}
