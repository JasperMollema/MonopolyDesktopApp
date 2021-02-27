package gui.listeners;

import gui.MainFrame;
import gui.component.SaveGameNameChecker;
import gui.controller.MonopolyGameController;
import messages.Messages;
import valueObjects.MonopolyGameValueObject;

import javax.swing.*;
import java.io.IOException;

public class SaveDialogListenerImpl extends AbstractSaveDialogListener {
    private MonopolyGameController monopolyGameController;

    public SaveDialogListenerImpl(MonopolyGameController monopolyGameController) {
        this.monopolyGameController = monopolyGameController;
    }

    @Override
    public void saveButtonPressed(String nameGame, SaveGameNameChecker saveGameNameChecker) {
        if (!saveGameNameChecker.nameGameIsAllowed(nameGame)) {
            showMessageNameNotAllowed();
            return;
        }

        boolean shouldSaveGame = true;

        if (saveGameNameChecker.nameIsInList(nameGame)) {
            shouldSaveGame = determineShouldSaveGame();
        }

        if (shouldSaveGame) {
            saveGame(nameGame);
        }
    }

    private void showMessageNameNotAllowed() {
        JOptionPane.showMessageDialog(
                null,
                Messages.getMessage("saveDialog.nameNotAllowed"),
                Messages.getMessage("saveDialog.nameNotAllowed"),
                JOptionPane.OK_OPTION);
    }

    private boolean determineShouldSaveGame() {
        int overwriteGame = JOptionPane.showConfirmDialog(
                null,
                Messages.getMessage("saveDialog.wantToOverWrite"),
                Messages.getMessage("saveDialog.nameAlreadyExists"),
                JOptionPane.OK_CANCEL_OPTION);
        return overwriteGame == JOptionPane.OK_OPTION;
    }

    private void saveGame(String nameGame) {
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameController.getMonopolyGameValueObject();
        try {
            saveGamesService.saveGame(nameGame, monopolyGameValueObject);
        } catch (IOException ioException) {
            System.err.println("SaveDialogListenerImpl : saveButtonPressed() Saving game failed.");
            ioException.printStackTrace();
        }
        monopolyGameController.setHasUnSavedChanges(false);
        closeDialog();
    }

    private void closeDialog() {
        monopolyGameController.hideSaveDialog();
        JOptionPane.showMessageDialog(
                MainFrame.mainFrame,
                Messages.getMessage("saveDialog.gameSaved")
        );
    }

    @Override
    public void overwriteButtonPressed(String gameToSave, String gameToOverwrite) {
        deleteGame(gameToOverwrite);
        saveGame(gameToSave);
    }

    @Override
    public void cancelButtonPressed() {
        monopolyGameController.hideSaveDialog();
    }

    @Override
    public void savedGameDoubleClicked(String selectedFile) {}

    @Override
    public void loadButtonPressed(String selectedFile) {}
}
