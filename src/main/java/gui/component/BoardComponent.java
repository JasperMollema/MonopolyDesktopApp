package gui.component;

import gui.view.AbstractGridBagView;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BoardComponent extends AbstractGridBagView {
    private String viewName;
    private JLabel name;
    private PlayerOnBoardSpaceComponent playerSpot;

    public BoardComponent(String viewName, Map<String, Color> playerColors) {
        this.viewName = viewName;
        setLayout(new BorderLayout());
        if (viewName != null) {
            playerSpot = new PlayerOnBoardSpaceComponent(playerColors);
            add(playerSpot, BorderLayout.CENTER);
            playerSpot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        if (viewName != null) {
            name = new JLabel(viewName);
            add(name, BorderLayout.NORTH);
            name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    @Override
    public String getViewName() {
        return viewName;
    }

    @Override
    public void initializeView() {

    }
}
