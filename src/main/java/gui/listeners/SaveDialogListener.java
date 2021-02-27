package gui.listeners;

import gui.component.SaveGameNameChecker;

public interface SaveDialogListener {
    void saveButtonPressed(String selectedFile, SaveGameNameChecker saveGameNameChecker);
    void overwriteButtonPressed(String gameToSave, String gameToOverwrite);
    void cancelButtonPressed();
    void loadButtonPressed(String selectedFile);
    void deleteButtonPressed(String selectedFile);
    void savedGameDoubleClicked(String selectedFile);
}
