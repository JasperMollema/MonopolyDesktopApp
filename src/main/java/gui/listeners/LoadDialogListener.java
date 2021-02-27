package gui.listeners;

import gui.component.SaveGameNameChecker;
import gui.controller.MainController;

import java.io.IOException;

public class LoadDialogListener extends AbstractSaveDialogListener {
    private MainController mainController;

    public LoadDialogListener(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void saveButtonPressed(String selectedFile, SaveGameNameChecker saveGameNameChecker) {

    }

    @Override
    public void overwriteButtonPressed(String gameToSave, String gameToOverwrite) {

    }

    @Override
    public void cancelButtonPressed() {
        mainController.hideLoadGameDialog();
    }

    @Override
    public void loadButtonPressed(String selectedFile) {
        loadGame(selectedFile);
    }

    @Override
    public void savedGameDoubleClicked(String selectedFile) {
        loadGame(selectedFile);
    }

    private void loadGame(String gameToLoad) {
        try {
            mainController.loadMonopolyGame(saveGamesService.loadGame(gameToLoad));
        } catch (IOException ioException) {
            System.out.println("LoadDialogListener: Failed to load game " + gameToLoad);
            ioException.printStackTrace();
            mainController.hideLoadGameDialog();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
