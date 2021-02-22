package gui.listeners;

import gui.component.GameSlot;

public interface SavedGamesListListener {
    void savedGameSelected(GameSlot gameSlot);
    void saveGameDoubleClicked(GameSlot gameSlot);
}
