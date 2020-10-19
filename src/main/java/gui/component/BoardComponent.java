package gui.component;

import javax.swing.*;
import javax.swing.border.Border;

public class BoardComponent extends JPanel {
    public BoardComponent(String name) {
        Border innerBorder = BorderFactory.createTitledBorder(name);
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
    }
}
