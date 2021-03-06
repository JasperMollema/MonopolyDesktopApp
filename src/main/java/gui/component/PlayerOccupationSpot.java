package gui.component;

import javax.swing.*;
import java.awt.*;

public class PlayerOccupationSpot extends JPanel {
    private boolean isOccupied;

    public void fillWithColor(Color color) {
        setBackground(color);
        setVisible(true);
        isOccupied = true;
    }

    public void empty() {
        setBackground(null);
        isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;}
}
