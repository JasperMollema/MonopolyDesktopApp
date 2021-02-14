package gui.listeners;

import gui.MainFrame;
import gui.controller.MonopolyGameController;
import messages.Messages;
import services.SaveGamesService;
import valueObjects.MonopolyGameValueObject;

import javax.swing.*;
import java.io.IOException;

public class SaveDialogListenerImpl implements SaveDialogListener {
    private MonopolyGameController monopolyGameController;
    private SaveGamesService saveGamesService;

    public SaveDialogListenerImpl(MonopolyGameController monopolyGameController) {
        this.monopolyGameController = monopolyGameController;
        saveGamesService = new SaveGamesService();
    }

    @Override
    public void saveButtonPressed(String nameGame) {
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameController.getMonopolyGameValueObject();
        try {
            saveGamesService.saveGame(nameGame, monopolyGameValueObject);
        } catch (IOException ioException) {
            System.err.println("SaveDialogListenerImpl : saveButtonPressed() Saving game failed.");
            ioException.printStackTrace();
        }
        monopolyGameController.hideSaveDialog();
        JOptionPane.showMessageDialog(
                MainFrame.mainFrame,
                Messages.getMessage("saveDialog.gameSaved")
        );
    }

    @Override
    public void loadButtonPressed(String selectedFile) {

    }

    @Override
    public void cancelButtonPressed() {
        monopolyGameController.hideSaveDialog();
    }

    @Override
    public void deleteButtonPressed(String selectedFile) {
        try {
            saveGamesService.deleteGame(selectedFile);
        } catch (IOException ioException) {
            System.err.println("SaveDialogListenerImpl : deleteButtonPressed() Deleting game failed.");
            ioException.printStackTrace();
        }
    }
}
