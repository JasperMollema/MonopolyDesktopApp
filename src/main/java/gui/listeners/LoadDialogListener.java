package gui.listeners;

import gui.controller.MainController;
import services.SaveGamesService;

public class LoadDialogListener implements SaveDialogListener {
    private MainController mainController;

    public LoadDialogListener(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void saveButtonPressed(String selectedFile) {

    }

    @Override
    public void cancelButtonPressed() {
        mainController.hideLoadGameDialog();
    }

    @Override
    public void loadButtonPressed(String selectedFile) {
        SaveGamesService saveGamesService = new SaveGamesService();

    }
}
