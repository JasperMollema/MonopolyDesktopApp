package gui.component;

import gui.view.AbstractGridBagView;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BoardComponent extends AbstractGridBagView {
    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel player3 = new JLabel();
    private JLabel player4 = new JLabel();
    private JLabel player5 = new JLabel();
    private JLabel player6 = new JLabel();
    private JLabel[] players;
    private String name;

    public BoardComponent(String name, Map<String, Color> playerColors) {
        this.name = name;
        players = new JLabel[]{player1, player2, player3, player4, player5, player6};
        setPlayersInvisible();
    }

    private void setPlayersInvisible() {
        for (int i = 0; i < players.length; i++) {
            players[i].setVisible(false);
        }
    }

    public void addPlayer(String playerName) {
        JLabel playerSpot = firstAvailablePlayerSpot();
        playerSpot.setText(playerName);
        playerSpot.setVisible(true);
    }

    private JLabel firstAvailablePlayerSpot() {
        JLabel playerSpot = null;
        for (int i = 0; i < players.length; i++) {
            playerSpot = players[i];
            if (isEmpty(playerSpot)) {
                break;
            }
        }
        return playerSpot;
    }

    private boolean isEmpty(JLabel playersSpot) {
        return playersSpot.getText() == null;
    }

    @Override
    public String getViewName() {
        return name;
    }

    @Override
    public void initializeView() {

    }
}
