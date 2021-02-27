package gui.listeners;

import gui.controller.MonopolyGameController;
import messages.Messages;

import javax.swing.*;

public class ToolbarListenerImpl implements ToolbarListener {
    private MonopolyGameController monopolyGameController;

    public ToolbarListenerImpl(MonopolyGameController monopolyGameController) {
        this.monopolyGameController = monopolyGameController;
    }

    @Override
    public void saveButtonPressed() {
        monopolyGameController.showSaveDialog();
    }

    @Override
    public void goToMainMenuButtonPressed() {
        if (monopolyGameController.hasUnSavedChanges() && !stillWantToGoToMainMenu()) {
            return;
        }
        monopolyGameController.goToMainMenu();
    }

    private boolean stillWantToGoToMainMenu() {
        int stillWantToGoMainMenu = JOptionPane.showConfirmDialog(
                null,
                Messages.getMessage("toolbar.confirmMessageGoToMenuText"),
                Messages.getMessage("toolbar.confirmMessageGoToMenuTitle"),
                JOptionPane.OK_CANCEL_OPTION);
        return stillWantToGoMainMenu == JOptionPane.OK_OPTION;
    }
}
