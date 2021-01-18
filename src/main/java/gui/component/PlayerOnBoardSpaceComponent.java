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
        addPlayers();
    }

    private void addPlayers() {
        playerOccupationSpots = new ArrayList<>();
        for (String player : playerColorMap.keySet()) {
            PlayerOccupationSpot occupationSpot = new PlayerOccupationSpot();
            occupationSpot.fillWithColor(playerColorMap.get(player));
            playerOccupationSpots.add(occupationSpot);
            add(occupationSpot);

        }
    }
}
