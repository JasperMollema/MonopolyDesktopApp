package gui.listeners;

import gui.controller.MainController;
import services.SaveGamesService;

import java.io.IOException;

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
        try {
            mainController.loadMonopolyGame(saveGamesService.loadGame(selectedFile));
        } catch (IOException ioException) {
            System.out.println("LoadDialogListener: Failed to load game " + selectedFile);
            ioException.printStackTrace();
            mainController.hideLoadGameDialog();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    @Override
    public void deleteButtonPressed(String selectedFile) {
        SaveGamesService saveGamesService = new SaveGamesService();
        try {
            saveGamesService.deleteGame(selectedFile);
        } catch (IOException ioException) {

        }
    }

    @Override
    public void savedGameDoubleClicked(String selectedFile) {
        loadButtonPressed(selectedFile);
    }
}
