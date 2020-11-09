package gui.component;

import gui.view.AbstractGridBagView;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends AbstractGridBagView {
    private JLabel name;
    private Color color;
    private JLabel money;

    public PlayerPanel(String player, Color color) {
        name = new JLabel(player);
        this.color = color;
        money = new JLabel("Money : 1500");
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(name, 1, 1);
        addComponentToGridBagConstraints(money, 1, 2);
        setVisible(true);
    }

    @Override
    public String getViewName() {
        return "PlayerPanel";
    }

    @Override
    public void initializeView() {

    }
}
