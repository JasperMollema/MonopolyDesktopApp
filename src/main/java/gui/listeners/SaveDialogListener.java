package gui.listeners;

public interface SaveDialogListener {
    void saveButtonPressed(String selectedFile);
    void cancelButtonPressed();
    void loadButtonPressed(String selectedFile);
}
