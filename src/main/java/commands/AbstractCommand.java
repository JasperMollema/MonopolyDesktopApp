package commands;

import gui.controller.MainController;

public abstract class AbstractCommand implements Command{
    private MainController mainController;

    @Override
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    protected MainController getMainController() {
        return mainController;
    }
}
