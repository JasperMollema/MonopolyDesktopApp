package gui.component;

import javax.swing.*;
import javax.swing.border.Border;

public class BoardComponent extends JPanel {
    private JLabel xCoordinate;
    private JLabel yCoordinate;

    public BoardComponent(String name) {
        Border innerBorder = BorderFactory.createTitledBorder(name);
        Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));

    }
}
