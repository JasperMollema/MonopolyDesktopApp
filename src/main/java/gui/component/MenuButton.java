package gui.component;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {
    public MenuButton(String text) {
        super(text);
        setPreferredSize(new Dimension(150, 30));
    }
}
