package gui.view;

import gui.component.BoardComponent;

import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class BoardView extends AbstractView {
    private Set<BoardComponent> boardComponents;

    public BoardView() {
        setVisible(true);
        setLayout(new GridLayout(11,11));
        setBackground(Color.LIGHT_GRAY);
    }

    public void fillBoardComponents(String[] boardComponentsToBeFilled, Map<String, Color> playerColors) {
        boardComponents = new HashSet<>();
        for (int i = 0; i < boardComponentsToBeFilled.length; i++) {

            String boardComponentName = fillName(boardComponentsToBeFilled[i]);
            BoardComponent boardComponent = new BoardComponent(boardComponentName, playerColors, i);
            add(boardComponent);
            boardComponent.setVisible(true);
            if (boardComponentName != null) {
                boardComponents.add(boardComponent);
                System.out.println("BoardView : Add " + boardComponentName + " to board.");
            }

        }
    }

    private String fillName(String messageResource) {
        return messageResource == null ? null : getMessage(messageResource);
    }

    public void setPlayerOnBoardComponent(String playerName, Integer boardComponentIdentifier) {
        Optional<BoardComponent> boardComponentOptional = boardComponents.stream()
                .filter(boardComp -> boardComp.getBoardComponentIdentifier().equals(boardComponentIdentifier))
                .findFirst();

        if (boardComponentOptional.isPresent()) {
            boardComponentOptional.get().putPlayerOnBoardSpace(playerName);
        }
    }

    @Override
    public void initializeView() {

    }

    @Override
    public String getViewName() {
        return "BoardView";
    }
}
