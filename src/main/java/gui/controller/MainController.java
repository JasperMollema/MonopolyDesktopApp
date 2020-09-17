package gui.controller;

import gui.listeners.MainMenuListenerImpl;
import gui.listeners.SelectNumberOfPlayersListenerImpl;
import gui.view.*;

public class MainController extends AbstractController {
    private MainView mainView;
    private MainMenuView mainMenuView;
    private MenuController menuController;
    private MonopolyGameView monopolyGameView;
    private MonopolyGameController monopolyGameController;
    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;

    private final String NAME_CONTROLLER = "MainController";

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initializeChildViews();
        initializeChildControllers();
        addChildViewsToMainView();
    }

    private void initializeChildViews() {
        mainMenuView = (MainMenuView) ViewFactory.getView(ViewFactory.MENU);
        selectNumberOfPlayersView = (SelectNumberOfPlayersView) ViewFactory.getView(ViewFactory.SELECT_NR_OF_PLAYERS);
        monopolyGameView = (MonopolyGameView) ViewFactory.getView(ViewFactory.MONOPOLY_GAME);
    }

    private void initializeChildControllers() {
        menuController = (MenuController) ControllerFactory.getController(mainMenuView);
        menuController.setMainMenuListener(new MainMenuListenerImpl(this));
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(selectNumberOfPlayersView);
        selectNumberOfPlayersController.setSelectNumberOfPlayersListener(new SelectNumberOfPlayersListenerImpl(this));
        monopolyGameController = (MonopolyGameController) ControllerFactory.getController(monopolyGameView);
    }

    private void addChildViewsToMainView() {
        mainView.addView(mainMenuView, mainMenuView.getViewName());
        mainView.addView(selectNumberOfPlayersView, selectNumberOfPlayersView.getViewName());
        mainView.addView(monopolyGameView, monopolyGameView.getViewName());
    }

    @Override
    public void startView() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        showMenu();
    }

    public void showMenu() {
        showView(mainMenuView);
    }

    public void showSelectNumberOfPlayersView() {
        showView(selectNumberOfPlayersView);
        selectNumberOfPlayersController.startView();
    }

    public void showMonopolyGameView() {
        showView(monopolyGameView);
        monopolyGameController.startView();
    }

    private void showView(AbstractView view) {
        mainView.showView(view.getViewName());
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }
}
