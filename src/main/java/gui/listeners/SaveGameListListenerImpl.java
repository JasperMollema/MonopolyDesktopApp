package gui.listeners;

import gui.component.GameSlot;
import gui.component.SaveDialog;

public class SaveGameListListenerImpl implements SavedGamesListListener {
    private SaveDialog saveDialog;

    public SaveGameListListenerImpl(SaveDialog saveDialog) {
        this.saveDialog = saveDialog;
    }

    @Override
    public void savedGameSelected(GameSlot gameSelected) {
        saveDialog.savedGameSelected(gameSelected);
    }

    @Override
    public void saveGameDoubleClicked(GameSlot gameSelected) {
        saveDialog.savedGameDoubleClicked(gameSelected);
    }
}
