package gui.controller;

import gui.view.MainView;
import gui.view.SelectNumberOfPlayersView;
import gui.view.ViewFactory;

public class MainController extends AbstractController {
    private MainView mainView;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;
    private final String NAME_CONTROLLER = "MenuController";

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initializeChildController();
    }

    private void initializeChildController() {
        SelectNumberOfPlayersView selectNrOfPlayersView = (SelectNumberOfPlayersView) ViewFactory.getView(ViewFactory.SELECT_NR_OF_PLAYERS);
        mainView.initializeView();
        mainView.addView(selectNrOfPlayersView, ViewFactory.SELECT_NR_OF_PLAYERS);
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(selectNrOfPlayersView);
        selectNumberOfPlayersController.startView();
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
