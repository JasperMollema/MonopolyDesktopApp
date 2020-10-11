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
    private CardLayout cardLayout;
    private Container container;

    public MainFrame() {
        System.out.println("Start Frame : MainFrame");
        cardLayout = new CardLayout();
        container = getContentPane();
        initializeFrame();
    }

    public void initializeFrame() {
        System.out.println("MainFrame : initializeFrame()");
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView = (MainView) ViewFactory.getView(ViewFactory.MAIN);
        mainView.setCardLayout(cardLayout);
        mainView.setContainer(container);
        mainView.setLayoutToContainer();
        mainController = (MainController) ControllerFactory.getController(mainView);
        add(mainView);
        mainController.startView();
        setVisible(true);
        pack();
    }
}
