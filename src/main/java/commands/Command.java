package commands;

import gui.controller.MainController;

public interface Command {
    void execute();
    void setMainController(MainController mainController);
}
