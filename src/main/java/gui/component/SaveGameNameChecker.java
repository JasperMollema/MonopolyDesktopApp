package gui.component;

import messages.Messages;

import java.util.List;

public class SaveGameNameChecker {
    private SavedGamesList savedGamesList;

    public SaveGameNameChecker(SavedGamesList savedGamesList) {
        this.savedGamesList = savedGamesList;
    }

    public boolean nameGameIsAllowed(String nameGameToBeSaved) {
        return !nameEqualsEmptySlot(nameGameToBeSaved);
    }

    public boolean nameIsInList(String nameGameToBeSaved) {
        return savedGamesList.nameIsInList(nameGameToBeSaved);
    }

    private boolean nameEqualsEmptySlot(String nameGameToBeSaved) {
        List<String> emptySlotValues = Messages.getAllValues("saveGamesList.emptySlot");
        for (String emptySlotValue : emptySlotValues) {
            if (emptySlotValue.equals(nameGameToBeSaved)) {
                return true;
            }
        }
        return false;
    }
}
