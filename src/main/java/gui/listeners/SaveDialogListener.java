package gui.listeners;

public interface SaveDialogListener {
    void saveButtonPressed(String selectedFile);
    void cancelButtonPressed();
    void loadButtonPressed(String selectedFile);
    void deleteButtonPressed(String selectedFile);
    void savedGameDoubleClicked(String selectedFile);
}
