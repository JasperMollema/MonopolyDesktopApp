package gui.listeners;

import gui.controller.MonopolyGameController;
import services.MonopolyGameService;

import java.io.IOException;

public class SaveDialogListenerImpl implements SaveDialogListener {
    private MonopolyGameController monopolyGameController;
    private MonopolyGameService monopolyGameService;

    public SaveDialogListenerImpl(MonopolyGameController monopolyGameController, MonopolyGameService monopolyGameService) {
        this.monopolyGameController = monopolyGameController;
        this.monopolyGameService = monopolyGameService;
    }

    @Override
    public void saveButtonPressed() {
        try {
            monopolyGameService.save();
        } catch (IOException ioException) {
            System.out.println("Saving game failed.");
        }
        monopolyGameController.hideSaveDialog();
    }

    @Override
    public void cancelButtonPressed() {
        monopolyGameController.hideSaveDialog();
    }
}
