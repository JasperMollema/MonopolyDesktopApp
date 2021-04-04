package gui.controller;

import gui.MainFrame;
import gui.component.SaveDialog;
import gui.listeners.*;
import gui.view.*;
import messages.Messages;
import valueObjects.MonopolyGameValueObject;
import valueObjects.PlayerValueObject;

import javax.swing.*;
import java.util.List;

public class MainController extends AbstractController {
    private MainView mainView;
    private MainMenuBagView mainMenuView;
    private MenuController menuController;
    private MonopolyGameView monopolyGameView;
    private MonopolyGameController monopolyGameController;
    private PlayersSetupView playersSetupView;
    private PlayersSetupController playersSetupController;
    private ChooseLanguageView chooseLanguageView;
    private ChooseLanguageController chooseLanguageController;
    private SaveDialog loadGameDialog;


    private final String NAME_CONTROLLER = "MainController";

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initialize();
    }

    private void initialize() {
        initializeChildViews();
        initializeChildControllers();
        addChildViewsToMainView();
        loadGameDialog = new SaveDialog(MainFrame.mainFrame, SaveDialog.SaveMode.LOAD);
        loadGameDialog.setSaveDialogListener(new LoadDialogListener(this));
        loadGameDialog.setVisible(false);
    }

    private void initializeChildViews() {
        mainMenuView = (MainMenuBagView) ViewFactory.getView(ViewFactory.MENU);
        playersSetupView = (PlayersSetupView) ViewFactory.getView(ViewFactory.SETUP_PLAYERS);
        monopolyGameView = (MonopolyGameView) ViewFactory.getView(ViewFactory.MONOPOLY_GAME);
        chooseLanguageView = (ChooseLanguageView) ViewFactory.getView(ViewFactory.CHOOSE_LANGUAGE);
    }

    private void initializeChildControllers() {
        menuController = (MenuController) ControllerFactory.getController(mainMenuView);
        menuController.setMainMenuListener(new MainMenuListenerImpl(this, menuController));
        playersSetupController = (PlayersSetupController) ControllerFactory.getController(playersSetupView);
        playersSetupController.setPlayersSetupListener(new PlayersSetupListenerImpl(this, playersSetupController));
        monopolyGameController = (MonopolyGameController) ControllerFactory.getController(monopolyGameView);
        monopolyGameController.setMonopolyGameListener(new MonopolyGameListenerImpl(this));
        chooseLanguageController = (ChooseLanguageController) ControllerFactory.getController(chooseLanguageView);
        chooseLanguageController.setChooseLanguageListener(new ChooseLanguageListenerImpl(this));
    }

    private void addChildViewsToMainView() {
        mainView.addView(mainMenuView, mainMenuView.getViewName());
        mainView.addView(playersSetupView, playersSetupView.getViewName());
        mainView.addView(monopolyGameView, monopolyGameView.getViewName());
        mainView.addView(chooseLanguageView, chooseLanguageView.getViewName());
    }

    @Override
    public void startController() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        showMenu();
    }

    public void
    startMonopolyGame(List<PlayerValueObject> players) {
        showMonopolyGameView();
        monopolyGameController.loadMonopolyGame(players);
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

    public void refresh() {
        initialize();
    }

    public void showSelectNumberOfPlayersView() {
        showView(playersSetupView);
        playersSetupController.startController();
    }

    public void showMonopolyGameView() {
        showView(monopolyGameView);
        monopolyGameController.startController();
    }


    public void showChooseLanguageView() {
        showView(chooseLanguageView);
        chooseLanguageController.startController();
    }

    private void showView(AbstractView view) {
        mainView.showView(view.getViewName());
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }
}
