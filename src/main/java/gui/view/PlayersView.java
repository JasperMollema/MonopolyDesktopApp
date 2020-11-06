package gui.view;

import javax.swing.*;

public class PlayersView extends AbstractGridBagView {
    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel player4;
    private JLabel player5;
    private JLabel player6;

    @Override
    public void initializeView() {
        initializeGridBagConstraints();
        setVisible(true);
    }

    public void initializePlayer1(String name) {
        player1 = new JLabel(name);
        addComponentToGridBagConstraints(player1, FIRST_COLUMN, FIRST_ROW);
    }

    public void initializePlayer2(String name) {
        player2 = new JLabel(name);
        addComponentToGridBagConstraints(player2, SECOND_COLUMN, FIRST_ROW);
    }

    public void initializePlayer3(String name) {
        player3 = new JLabel(name);
        addComponentToGridBagConstraints(player3, FIRST_COLUMN, SECOND_ROW);
    }

    public void initializePlayer4(String name) {
        player4 = new JLabel(name);
        addComponentToGridBagConstraints(player4, SECOND_COLUMN, SECOND_ROW);
    }

    public void initializePlayer5(String name) {
        player5 = new JLabel(name);
        addComponentToGridBagConstraints(player5, FIRST_COLUMN, THIRD_ROW);
    }

    public void initializePlayer6(String name) {
        player6 = new JLabel(name);
        addComponentToGridBagConstraints(player6, SECOND_COLUMN, THIRD_ROW);
    }

    @Override
    public String getViewName() {
        return "PlayerOverview";
    }
}
