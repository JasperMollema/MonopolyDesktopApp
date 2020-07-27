package gui;

import gui.view.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private List<AbstractView> views;

    public MainFrame(List<AbstractView> views) {
        this.views = views;
        initializeFrame();
        addViews();
    }

    private void initializeFrame() {
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addViews() {
        for (AbstractView view : views) {
            add(view);
        }
    }
}
