package gui.controller;

import gui.view.MainView;
import gui.view.MenuView;
import gui.view.SelectNumberOfPlayersView;
import gui.view.ViewFactory;

public class MainController extends AbstractController {
    private MainView mainView;
    private MenuView menuView;
    private MenuController menuController;
    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;

    private final String NAME_CONTROLLER = "MainController";

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initializeChildViews();
        initializeChildControllers();
        mainView.initializeView();
    }

    private void initializeChildViews() {
        menuView = (MenuView) ViewFactory.getView(ViewFactory.MENU);
        selectNumberOfPlayersView = (SelectNumberOfPlayersView) ViewFactory.getView(ViewFactory.SELECT_NR_OF_PLAYERS);
    }

    private void initializeChildControllers() {
        menuController = (MenuController) ControllerFactory.getController(menuView);
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(selectNumberOfPlayersView);
    }

    @Override
    public void startView() {
        System.out.println(NAME_CONTROLLER + " : startView()");
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }
}
