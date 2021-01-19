package gui.view;

import gui.component.BoardComponent;

import java.awt.*;
import java.util.*;

public class BoardView extends AbstractView {
    private Set<BoardComponent> boardComponents;

    public BoardView() {
        setVisible(true);
        setLayout(new GridLayout(11,11));
        setBackground(Color.LIGHT_GRAY);
    }

    public void fillBoardComponents(String[] boardComponentsToBeFilled, Map<String, Color> playerColors) {
        boardComponents = new HashSet<>();
        for (String boardComponentMessageResource : Arrays.asList(boardComponentsToBeFilled)) {

            String boardComponentName = fillName(boardComponentMessageResource);
            BoardComponent boardComponent = new BoardComponent(boardComponentName, playerColors);
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

    public void setPlayerOnBoardComponent(String playerName, String boardComponentMessageResource) {
        String boardComponentName = getMessage(boardComponentMessageResource);
        Optional<BoardComponent> boardComponentOptional = boardComponents.stream()
                .filter(boardComp -> boardComp.getName().equals(boardComponentName))
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
