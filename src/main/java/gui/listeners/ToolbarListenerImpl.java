package gui.listeners;

import gui.controller.MonopolyGameController;

public class ToolbarListenerImpl implements ToolbarListener {
    private MonopolyGameController monopolyGameController;

    public ToolbarListenerImpl(MonopolyGameController monopolyGameController) {
        this.monopolyGameController = monopolyGameController;
    }

    @Override
    public void saveButtonPressed() {
        monopolyGameController.showSaveDialog();
    }
}
