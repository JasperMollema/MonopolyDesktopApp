package gui.listeners;

import gui.controller.MonopolyGameController;

public class SaveDialogListenerImpl implements SaveDialogListener {
    private MonopolyGameController monopolyGameController;

    public SaveDialogListenerImpl(MonopolyGameController monopolyGameController) {
        this.monopolyGameController = monopolyGameController;
    }

    @Override
    public void saveButtonPressed(String nameGame) {
        monopolyGameController.saveGame(nameGame);
        monopolyGameController.hideSaveDialog();
    }

    @Override
    public void loadButtonPressed(String selectedFile) {

    }

    @Override
    public void cancelButtonPressed() {
        monopolyGameController.hideSaveDialog();
    }
}
