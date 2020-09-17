package gui.controller;

import gui.view.*;

public class MainController extends AbstractController {
    private MainView mainView;
    private MainMenuView mainMenuView;
    private MenuController menuController;
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
    }

    private void initializeChildControllers() {
        menuController = (MenuController) ControllerFactory.getController(mainMenuView);
        menuController.setMainMenuListener(() -> {showSelectNumberOfPlayersView();});
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(selectNumberOfPlayersView);
    }

    private void addChildViewsToMainView() {
        mainView.addView(mainMenuView, mainMenuView.getViewName());
        mainView.addView(selectNumberOfPlayersView, selectNumberOfPlayersView.getViewName());
    }

    @Override
    public void startView() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        showMenu();
    }

    private void showMenu() {
        showView(mainMenuView);
    }

    private void showSelectNumberOfPlayersView() {
        showView(selectNumberOfPlayersView);
        selectNumberOfPlayersController.startView();
    }

    private void showView(AbstractView view) {
        mainView.showView(view.getViewName());
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }
}
