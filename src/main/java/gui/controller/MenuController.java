package gui.controller;

import gui.view.MenuView;

public class MenuController extends AbstractController {
    private MenuView menuView;
    private final String NAME_CONTROLLER = "MenuController";

    public MenuController(MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }

    @Override
    public void startView() {

    }
}
