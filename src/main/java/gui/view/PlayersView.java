package gui.view;

import gui.component.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class PlayersView extends AbstractView {
    private PlayerPanel player1;
    private PlayerPanel player2;
    private PlayerPanel player3;
    private PlayerPanel player4;
    private PlayerPanel player5;
    private PlayerPanel player6;

    public PlayersView() {
        setLayout(new GridLayout(3, 2));
    }

    @Override
    public void initializeView() {
        setVisible(true);
    }

    public void initializePlayer1(String name, Color color) {
        player1 = new PlayerPanel(name, color);
        player1.setBorder(BorderFactory.createLineBorder(color));
        add(player1);
    }

    public void initializePlayer2(String name, Color color) {
        player2 = new PlayerPanel(name, color);
        player1.setBorder(BorderFactory.createLineBorder(color));
        add(player2);
    }

    public void initializePlayer3(String name, Color color) {
        player3 = new PlayerPanel(name, color);
        player1.setBorder(BorderFactory.createLineBorder(color));
        add(player3);
    }

    public void initializePlayer4(String name, Color color) {
        player4 = new PlayerPanel(name, color);
        player1.setBorder(BorderFactory.createLineBorder(color));
        add(player4);
    }

    public void initializePlayer5(String name, Color color) {
        player5 = new PlayerPanel(name, color);
        player1.setBorder(BorderFactory.createLineBorder(color));
        add(player5);
    }

    public void initializePlayer6(String name, Color color) {
        player6 = new PlayerPanel(name, color);
        player1.setBorder(BorderFactory.createLineBorder(color));
        add(player6);
    }

    @Override
    public String getViewName() {
        return "PlayerOverview";
    }

    public void emptyPlayers() {
        player1 = null;
        player2 = null;
        player3 = null;
        player4 = null;
        player5 = null;
        player6 = null;
    }
}
