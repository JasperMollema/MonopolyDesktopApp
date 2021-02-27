package gui.view;

import gui.component.BoardComponent;
import valueObjects.BoardSpaceValueObject;

import java.awt.*;
import java.util.List;
import java.util.*;

public class BoardView extends AbstractView {
    private Set<BoardComponent> boardComponents;

    public BoardView() {
        setVisible(true);
        setLayout(new GridLayout(11,11));
        setBackground(Color.LIGHT_GRAY);
    }

    public void fillBoardComponents(List<BoardSpaceValueObject> boardSpaceValueObjects, Map<String, Color> playerColors) {
        boardComponents = new HashSet<>();
        for (BoardSpaceValueObject boardSpaceValueObject : boardSpaceValueObjects) {
            BoardComponent boardComponent;

            if (boardSpaceValueObject == null) {
                boardComponent = new BoardComponent();
            } else {
                String boardComponentName = getMessage(boardSpaceValueObject.name);
                int boardComponentIdentifier = boardSpaceValueObject.identifier;
                boardComponent = new BoardComponent(boardComponentName, boardComponentIdentifier, playerColors);
                boardComponents.add(boardComponent);
                System.out.println("BoardView : Add " + boardComponentName + " to board.");
            }
            boardComponent.setVisible(true);
            add(boardComponent);
        }

    }

    public void setPlayerOnBoardComponent(String playerName, Integer boardComponentIdentifier) {
        Optional<BoardComponent> boardComponentOptional = boardComponents.stream()
                .filter(boardComp -> boardComp.getBoardComponentIdentifier().equals(boardComponentIdentifier))
                .findFirst();

        if (boardComponentOptional.isPresent()) {
            boardComponentOptional.get().putPlayerOnBoardSpace(playerName);
        }
    }

    public void removePlayerFromBoardComponent(String playerName, Integer boardComponentIdentifier) {
        Optional<BoardComponent> boardComponentOptional = boardComponents.stream()
                .filter(boardComp -> boardComp.getBoardComponentIdentifier().equals(boardComponentIdentifier))
                .findFirst();

        if (boardComponentOptional.isPresent()) {
            boardComponentOptional.get().removePlayerFromBoardSpace(playerName);
        }
    }

    public void emptyBoard() {
        boardComponents = null;
    }

    @Override
    public void initializeView() {

    }

    @Override
    public String getViewName() {
        return "BoardView";
    }
}
