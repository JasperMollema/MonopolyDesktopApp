package gui.component;

import javax.swing.*;
import java.awt.*;

public class PlayerOccupationSpot extends JPanel {

    public void fillWithColor(Color color) {
        setVisible(true);
        setBackground(color);
    }

    public void empty() {
        setVisible(false);
    }
}
