package gui.component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerOnBoardSpaceComponent extends JPanel {
    private int[] positionPlayer1 = new int[]{10, 10};
    private int[] positionPlayer2 = new int[]{50, 10};
    private int[] positionPlayer3 = new int[]{80, 10};
    private int[] positionPlayer4 = new int[]{10, 80};
    private int[] positionPlayer5 = new int[]{50, 80};
    private int[] positionPlayer6 = new int[]{80, 80};

    private Map<String, Boolean> playerOccupants;
    private Map<String, Color> playerColors;
    private Map<String, int[]> playerPositions;
    private Set<String> players;

    private PlayerOccupationSpot player1 = new PlayerOccupationSpot();
    private PlayerOccupationSpot player2 = new PlayerOccupationSpot();
    private PlayerOccupationSpot player3 = new PlayerOccupationSpot();
    private PlayerOccupationSpot player4 = new PlayerOccupationSpot();
    private PlayerOccupationSpot player5 = new PlayerOccupationSpot();
    private PlayerOccupationSpot player6 = new PlayerOccupationSpot();

    public PlayerOnBoardSpaceComponent(Map<String, Color> playerColors) {
        this.playerColors = playerColors;
        fillPlayerCollections();
        setLayout(new GridLayout(2,3));
        add(player1);
        add(player2);
        add(player3);
        add(player4);
        add(player5);
        add(player6);
    }

    private void fillPlayerCollections() {
        players = playerColors.keySet();
        fillPlayerOccupants();
        fillPlayerPositions();
    }

    private void fillPlayerOccupants() {
        playerOccupants = new HashMap<>();
        for (String player : players) {
            playerOccupants.put(player, true);
        }
    }

    private void fillPlayerPositions() {
        playerPositions = new HashMap<>();
        int[][] positions = new int[][] {
                positionPlayer1, positionPlayer2, positionPlayer3, positionPlayer4, positionPlayer5, positionPlayer6};
        int playerNumber = 0;
        for (String player : players) {
            playerPositions.put(player, positions[playerNumber]);
            playerNumber++;
        }
    }
}
