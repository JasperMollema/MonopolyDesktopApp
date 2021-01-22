package gui.component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerOnBoardSpaceComponent extends JPanel {
    private Map<String, Color> playerColorMap;
    private List<PlayerOccupationSpot> playerOccupationSpots;
    private Map<String, PlayerOccupationSpot> playerOccupationSpotMap;


    public PlayerOnBoardSpaceComponent(Map<String, Color> playerColors) {
        playerColorMap = playerColors;
        playerOccupationSpotMap = new HashMap<>();
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
                playerOccupationSpotMap.put(player, playerOccupationSpot);
                return;
            }
        }
        throw new RuntimeException("PlayerOnBoardSpaceComponent : setPlayerOnBoarSpace() Trying to put a player on a full boardspace.");
    }

    public void removePlayerFromBoardSpace(String player) {
        PlayerOccupationSpot playerOccupationSpot = playerOccupationSpotMap.get(player);
        playerOccupationSpot.empty();
    }
}
