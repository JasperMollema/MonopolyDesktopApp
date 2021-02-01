package gui.listeners;

import gui.MainFrame;
import gui.component.SaveDialog;
import gui.controller.MonopolyGameController;
import services.MonopolyGameService;

public class ToolbarListenerImpl implements ToolbarListener {
    private MonopolyGameController monopolyGameController;
    private MonopolyGameService monopolyGameService;
    private SaveDialog saveDialog;

    public ToolbarListenerImpl(MonopolyGameController monopolyGameController, MonopolyGameService monopolyGameService) {
        this.monopolyGameController = monopolyGameController;
        this.monopolyGameService = monopolyGameService;
        saveDialog = new SaveDialog(MainFrame.mainFrame);
    }

    @Override
    public void saveButtonPressed() {
        monopolyGameController.showSaveDialog();
    }
}
