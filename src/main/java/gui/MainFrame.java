package gui;

import gui.controller.ControllerFactory;
import gui.controller.MainController;
import gui.view.MainView;
import gui.view.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MainView mainView;
    private MainController mainController;

    public MainFrame() {
        mainView = (MainView) ViewFactory.getView(ViewFactory.MAIN);
        mainController = (MainController) ControllerFactory.getController(mainView);
        initializeFrame();
        mainController.startView();
    }

    public void initializeFrame() {
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(mainView);
    }
}
