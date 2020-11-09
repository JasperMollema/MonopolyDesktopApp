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

    public void fillBoardComponents(String[] boardComponents, Map<String, Color> playerColors) {
        int numberOfBoardComponents = boardComponents.length;
        this.boardComponents = new BoardComponent[numberOfBoardComponents];
        for (int i = 0; i < numberOfBoardComponents; i++) {

            String boardComponentName = fillName(boardComponents[i]);
            this.boardComponents[i] = new BoardComponent(boardComponentName, playerColors);
            add(this.boardComponents[i]);
        }
    }

    private String fillName(String messageResource) {
        return messageResource == null ? null : getMessage(messageResource);
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
