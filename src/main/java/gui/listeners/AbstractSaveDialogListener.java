package gui.listeners;

import gui.MainFrame;
import messages.Messages;
import services.SaveGamesService;

import javax.swing.*;
import java.io.IOException;

public abstract class AbstractSaveDialogListener implements SaveDialogListener {
    protected SaveGamesService saveGamesService;

    public AbstractSaveDialogListener() {
        saveGamesService = new SaveGamesService();
    }

    @Override
    public void deleteButtonPressed(String selectedFile) {
        if (reallyDeleteGame(selectedFile)) {
            deleteGame(selectedFile);
        }
    }

    private boolean reallyDeleteGame(String nameGame) {
        int deleteGame = JOptionPane.showConfirmDialog(
                MainFrame.mainFrame,
                Messages.getMessage("saveDialog.reallyDeleteGame", nameGame),
                Messages.getMessage("saveDialog.deleteGame"),
                JOptionPane.OK_CANCEL_OPTION
        );
        return deleteGame == JOptionPane.OK_OPTION;
    }

    protected void deleteGame(String gameName) {
        try {
            saveGamesService.deleteGame(gameName);
        } catch (IOException ioException) {
            System.out.println("AbstractSaveDialogListener deleteGame() : deleting game failed.");
            ioException.printStackTrace();
        }
    }
}
