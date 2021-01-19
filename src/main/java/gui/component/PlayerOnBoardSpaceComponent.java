package gui.component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerOnBoardSpaceComponent extends JPanel {
    private Map<String, Color> playerColorMap;
    private List<PlayerOccupationSpot> playerOccupationSpots;


    public PlayerOnBoardSpaceComponent(Map<String, Color> playerColors) {
        playerColorMap = playerColors;
        setLayout(new GridLayout());
        addPlayerOccupationSpots();
    }

    private void addPlayerOccupationSpots() {
        playerOccupationSpots = new ArrayList<>();
        for (int i = 0; i < playerColorMap.size(); i++) {
            PlayerOccupationSpot occupationSpot = new PlayerOccupationSpot();
            playerOccupationSpots.add(occupationSpot);
            add(occupationSpot);

        }
    }

    public void setPlayersOnBoardSpace(String player) {
        Color color = playerColorMap.get(player);
        for (PlayerOccupationSpot playerOccupationSpot : playerOccupationSpots) {
            if (!playerOccupationSpot.isOccupied()) {
                playerOccupationSpot.fillWithColor(color);
                return;
            }
        }
        throw new RuntimeException("PlayerOnBoardSpaceComponent : setPlayerOnBoarSpace() Trying to put a player on a full boardspace.");
    }
}
