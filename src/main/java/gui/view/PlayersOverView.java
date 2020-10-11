package gui.view;

import javax.swing.*;

public class PlayersOverView extends AbstractGridBagView {
    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel player4;
    private JLabel player5;
    private JLabel player6;

    @Override
    public void initializeView() {
        initializeGridBagConstraints();
    }

    public void initializePlayer1(String name) {
        player1 = new JLabel(name);
    }

    public void initializePlayer2(String name) {
        player2 = new JLabel(name);
    }

    public void initializePlayer3(String name) {
        player3 = new JLabel(name);
    }

    public void initializePlayer4(String name) {
        player4 = new JLabel(name);
    }

    public void initializePlayer5(String name) {
        player5 = new JLabel(name);
    }

    public void initializePlayer6(String name) {
        player6 = new JLabel(name);
    }

    @Override
    public String getViewName() {
        return "PlayerOverview";
    }
}
