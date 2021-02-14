package gui.controller;

import gui.MainFrame;
import gui.component.SaveDialog;
import gui.listeners.LoadDialogListener;
import gui.listeners.MainMenuListenerImpl;
import gui.listeners.SelectNumberOfPlayersListenerImpl;
import gui.view.*;
import messages.Messages;
import valueObjects.MonopolyGameValueObject;

import javax.swing.*;
import java.util.List;

public class MainController extends AbstractController {
    private MainView mainView;
    private MainMenuBagView mainMenuView;
    private MenuController menuController;
    private MonopolyGameView monopolyGameView;
    private MonopolyGameController monopolyGameController;
    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;
    private SaveDialog loadGameDialog;


    private final String NAME_CONTROLLER = "MainController";

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initializeChildViews();
        initializeChildControllers();
        addChildViewsToMainView();
        loadGameDialog = new SaveDialog(MainFrame.mainFrame, SaveDialog.SaveMode.LOAD);
        loadGameDialog.setSaveDialogListener(new LoadDialogListener(this));
        loadGameDialog.setVisible(false);
    }

    private void initializeChildViews() {
        mainMenuView = (MainMenuBagView) ViewFactory.getView(ViewFactory.MENU);
        selectNumberOfPlayersView = (SelectNumberOfPlayersView) ViewFactory.getView(ViewFactory.SELECT_NR_OF_PLAYERS);
        monopolyGameView = (MonopolyGameView) ViewFactory.getView(ViewFactory.MONOPOLY_GAME);
    }

    private void initializeChildControllers() {
        menuController = (MenuController) ControllerFactory.getController(mainMenuView);
        menuController.setMainMenuListener(new MainMenuListenerImpl(this));
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(selectNumberOfPlayersView);
        selectNumberOfPlayersController.setSelectNumberOfPlayersListener(new SelectNumberOfPlayersListenerImpl(this, selectNumberOfPlayersController));
        monopolyGameController = (MonopolyGameController) ControllerFactory.getController(monopolyGameView);
    }

    private void addChildViewsToMainView() {
        mainView.addView(mainMenuView, mainMenuView.getViewName());
        mainView.addView(selectNumberOfPlayersView, selectNumberOfPlayersView.getViewName());
        mainView.addView(monopolyGameView, monopolyGameView.getViewName());
    }

    @Override
    public void startController() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        showMenu();
    }

    public void
    startMonopolyGame(List<String> playerNames) {
        showMonopolyGameView();
        monopolyGameController.loadMonopolyGame(playerNames);
    }

    public void showLoadGameDialog() {
        loadGameDialog.initializeGamesList();
        if (loadGameDialog.isEmpty()) {
            JOptionPane.showMessageDialog(
                    MainFrame.mainFrame,
                    Messages.getMessage("mainController.noGamesToLoad")
            );
            return;
        }
        loadGameDialog.setVisible(true);
    }

    public void hideLoadGameDialog() {
        loadGameDialog.setVisible(false);
    }

    public void loadMonopolyGame(MonopolyGameValueObject monopolyGameValueObject) {
        showMonopolyGameView();
        hideLoadGameDialog();
        monopolyGameController.loadMonopolyGame(monopolyGameValueObject);
    }

    public void showMenu() {
        showView(mainMenuView);
    }

    public void showSelectNumberOfPlayersView() {
        showView(selectNumberOfPlayersView);
        selectNumberOfPlayersController.startController();
    }

    public void showMonopolyGameView() {
        showView(monopolyGameView);
        monopolyGameController.startController();
    }

    private void showView(AbstractView view) {
        mainView.showView(view.getViewName());
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }
}
