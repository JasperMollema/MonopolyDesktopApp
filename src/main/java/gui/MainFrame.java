package gui;

import gui.controller.ControllerFactory;
import gui.controller.MainController;
import gui.controller.MenuController;
import gui.controller.SelectNumberOfPlayersController;
import gui.view.MainMenuView;
import gui.view.MainView;
import gui.view.SelectNumberOfPlayersView;
import gui.view.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MainView mainView;
    private MainMenuView mainMenuView;
    private MenuController menuController;
    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;
    private MainController mainController;
    private CardLayout cardLayout;
    private Container container;

    private JButton but1, but2, but3;

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

    private void initializeChildViews() {
        mainMenuView = (MainMenuView) ViewFactory.getView(ViewFactory.MENU);
        selectNumberOfPlayersView = (SelectNumberOfPlayersView) ViewFactory.getView(ViewFactory.SELECT_NR_OF_PLAYERS);
    }

    private void initializeChildControllers() {
        menuController = (MenuController) ControllerFactory.getController(mainMenuView);
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(selectNumberOfPlayersView);
    }

    private void addChildViews() {
        container.add(mainMenuView, mainMenuView.getViewName());
        container.add(selectNumberOfPlayersView, selectNumberOfPlayersView.getViewName());
    }

    private void showMenu() {
        cardLayout.show(container, mainMenuView.getViewName());
    }
}
