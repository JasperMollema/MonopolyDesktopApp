package gui.component;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BoardComponent extends JPanel {
    private JLabel nameLabel;
    private PlayerOnBoardSpaceComponent playerOnBoardSpaceComponent;
    private Integer boardComponentIdentifier;

    public BoardComponent() {}

    public BoardComponent(String name, Integer boardComponentIdentifier, Map<String, Color> playerColors) {
        this.boardComponentIdentifier = boardComponentIdentifier;

        setName(name);

        setLayout(new BorderLayout());
        playerOnBoardSpaceComponent = new PlayerOnBoardSpaceComponent(playerColors);
        add(playerOnBoardSpaceComponent, BorderLayout.CENTER);
        playerOnBoardSpaceComponent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.nameLabel = new JLabel(name);
        add(this.nameLabel, BorderLayout.NORTH);
        this.nameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void putPlayerOnBoardSpace(String player) {
        playerOnBoardSpaceComponent.setPlayersOnBoardSpace(player);
    }

    public void removePlayerFromBoardSpace(String player) {
        playerOnBoardSpaceComponent.removePlayerFromBoardSpace(player);
    }

    public Integer getBoardComponentIdentifier() {
        return boardComponentIdentifier;
    }
}
