package gui.listeners;

import gui.component.SaveDialog;

public class SaveGameListListenerImpl implements SavedGamesListListener {
    private SaveDialog saveDialog;

    public SaveGameListListenerImpl(SaveDialog saveDialog) {
        this.saveDialog = saveDialog;
    }

    @Override
    public void savedGameSelected(String gameSelected) {
        saveDialog.savedGameSelected(gameSelected);
    }
}
