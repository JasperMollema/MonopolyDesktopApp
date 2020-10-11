package gui.view;

import javax.swing.*;

public class MonopolyGameView extends AbstractView {
    private JLabel monopolyGame;
    private PlayersOverView playersOverView;

    @Override
    public String getViewName() {
        return "MonopolyGameView";
    }

    @Override
    public void initializeView() {
        monopolyGame = new JLabel("Monopoly Game");
        add(monopolyGame);
    }

    public void addPlayerLabel(String playerName) {

    }
}
