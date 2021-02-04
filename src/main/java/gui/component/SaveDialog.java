package gui.component;

import gui.listeners.SaveDialogListener;
import gui.listeners.SaveGameListListenerImpl;
import messages.Messages;

import javax.swing.*;
import java.awt.*;

public class SaveDialog extends JDialog {
    private SavedGamesList savedGamesList;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton loadGameButton;
    private SaveDialogListener saveDialogListener;
    private JLabel selectedGame;
    private JTextField gameToSave;
    private SaveMode saveMode;

    public enum SaveMode {SAVE, LOAD}


    public SaveDialog(Frame owner, SaveMode saveMode) {
        super(owner, "Save Game", true);
        setSize(400, 600);
        setLocationRelativeTo(owner);

        saveButton = new JButton(Messages.getMessage("saveDialog.save"));
        loadGameButton = new JButton(Messages.getMessage("saveDialog.loadGame"));
        cancelButton = new JButton(Messages.getMessage("saveDialog.cancel"));
        selectedGame = new JLabel();
        gameToSave = new JTextField(10);
        savedGamesList = new SavedGamesList();
        this.saveMode = saveMode;

        addActionListeners();
        layoutComponents();
        adjustToMode();
    }

    private void addActionListeners() {
        gameToSave.addActionListener(event -> {
            saveButton.setText(Messages.getMessage("saveDialog.save"));
        });

        saveButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.saveButtonPressed(gameToSave.getText());
            }
        });

        loadGameButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.loadButtonPressed(gameToSave.getText());
            }
        });

        cancelButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.cancelButtonPressed();
            }
        });
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel saveGamePanel = new JPanel(new FlowLayout());
        saveGamePanel.add(selectedGame);
        saveGamePanel.add(gameToSave);
        add(saveGamePanel, BorderLayout.NORTH);

        add(savedGamesList, BorderLayout.CENTER);
        savedGamesList.setSavedGamesListListener(new SaveGameListListenerImpl(this));
        String nrOfSavedGames = savedGamesList.getNrOfSavedGames();
        gameToSave.setText(Messages.getMessage("saveDialog.defaultTextSaveGame", nrOfSavedGames));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void adjustToMode() {
        if (saveMode == SaveMode.SAVE) {
            loadGameButton.setVisible(false);
            selectedGame.setText(Messages.getMessage("saveDialog.gameToSave"));
        }

        if (saveMode == SaveMode.LOAD) {
            saveButton.setVisible(false);
            gameToSave.setVisible(false);
        }
    }

    public void setSaveDialogListener(SaveDialogListener saveDialogListener) {
        this.saveDialogListener = saveDialogListener;
    }

    public void savedGameSelected(String selectedGame) {
        gameToSave.setText(selectedGame);
        saveButton.setText(Messages.getMessage("saveDialog.overwrite"));
        if (saveMode == SaveMode.LOAD) {
            this.selectedGame.setText(selectedGame);
        }
    }
}
