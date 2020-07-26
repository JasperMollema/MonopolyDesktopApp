package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        addComponents();
        configureFrame();

    }

    private void addComponents() {
        OpeningMenuView openingMenuView = new OpeningMenuView();
        OpeningMenuController openingMenuController = new OpeningMenuController(openingMenuView);
        add(openingMenuView);

    }

    private void configureFrame() {
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
