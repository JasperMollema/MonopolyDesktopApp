package gui.component;

import gui.MainFrame;
import gui.listeners.SaveDialogListener;
import gui.listeners.SaveGameListListenerImpl;
import messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SaveDialog extends JDialog {
    private SavedGamesList savedGamesList;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton loadGameButton;
    private JButton deleteButton;
    private SaveDialogListener saveDialogListener;
    private JLabel selectedGame;
    private JTextField gameToSave;
    private SaveMode saveMode;

    public enum SaveMode {SAVE, LOAD}


    public SaveDialog(Frame owner, SaveMode saveMode) {
        super(owner, saveMode.name() + " Game", true);
        setSize(400, 600);
        setLocationRelativeTo(owner);

        saveButton = new JButton(Messages.getMessage("saveDialog.save"));
        loadGameButton = new JButton(Messages.getMessage("saveDialog.loadGame"));
        deleteButton = new JButton(Messages.getMessage("saveDialog.delete"));
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
        gameToSave.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                savedGamesList.clearSelection();
                saveButton.setText(Messages.getMessage("saveDialog.save"));
                if (gameToSave.getText().isBlank()) {
                    saveButton.setEnabled(false);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        saveButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.saveButtonPressed(gameToSave.getText());
                savedGamesList.addGame(gameToSave.getText());
            }
        });

        loadGameButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.loadButtonPressed(gameToSave.getText());
            }
        });

        deleteButton.addActionListener(event -> {
            if (saveDialogListener != null && reallyDeleteGame(gameToSave.getText())) {
                saveDialogListener.deleteButtonPressed(gameToSave.getText());
                savedGamesList.removeGame(gameToSave.getText());
                deleteButton.setVisible(savedGamesList.isEmpty());
            }
        });

        cancelButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.cancelButtonPressed();
            }
        });
    }

    private boolean reallyDeleteGame(String nameGame) {
        int deleteGame = JOptionPane.showConfirmDialog(
                MainFrame.mainFrame,
                Messages.getMessage("saveDialog.reallyDeleteGame", nameGame),
                Messages.getMessage("saveDialog.deleteGame"),
                JOptionPane.OK_CANCEL_OPTION
        );
        return deleteGame == JOptionPane.OK_OPTION;
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel saveGamePanel = new JPanel(new FlowLayout());
        saveGamePanel.add(selectedGame);
        saveGamePanel.add(gameToSave);
        add(saveGamePanel, BorderLayout.NORTH);

        add(savedGamesList, BorderLayout.CENTER);
        savedGamesList.setSavedGamesListListener(new SaveGameListListenerImpl(this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(deleteButton);
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
            selectedGame.setText(Messages.getMessage("saveDialog.gameToLoad"));
        }
    }

    public void initializeGamesList() {
        savedGamesList.initializeList();
        if (savedGamesList.isEmpty()) {
            loadGameButton.setVisible(false);
            deleteButton.setVisible(false);
        }
        gameToSave.setText(savedGamesList.determineTextNewGame());
    }

    public boolean isEmpty() {
        return savedGamesList.isEmpty();
    }

    public void setSaveDialogListener(SaveDialogListener saveDialogListener) {
        this.saveDialogListener = saveDialogListener;
    }

    public void savedGameSelected(String selectedGame) {
        gameToSave.setText(selectedGame);
        saveButton.setText(Messages.getMessage("saveDialog.overwrite"));
    }
}
