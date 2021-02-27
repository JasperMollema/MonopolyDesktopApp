package gui.component;

import gui.listeners.SaveDialogListener;
import gui.listeners.SaveGameListListenerImpl;
import messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SaveDialog extends JDialog {
    private SavedGamesList savedGamesList;
    private JButton saveButton;
    private JButton overWriteButton;
    private JButton cancelButton;
    private JButton loadGameButton;
    private JButton deleteButton;
    private SaveDialogListener saveDialogListener;
    private JLabel selectedGame;
    private GameSlotTextField gameInputField;
    private SaveMode saveMode;
    private SaveGameNameChecker saveGameNameChecker;

    public enum SaveMode {SAVE, LOAD}


    public SaveDialog(Frame owner, SaveMode saveMode) {
        super(owner, saveMode.name() + " Game", true);
        setSize(400, 600);
        setLocationRelativeTo(owner);

        saveButton = new JButton(Messages.getMessage("saveDialog.save"));
        overWriteButton = new JButton(Messages.getMessage("saveDialog.overwrite"));
        loadGameButton = new JButton(Messages.getMessage("saveDialog.loadGame"));
        deleteButton = new JButton(Messages.getMessage("saveDialog.delete"));
        cancelButton = new JButton(Messages.getMessage("saveDialog.cancel"));
        selectedGame = new JLabel();
        gameInputField = new GameSlotTextField();
        savedGamesList = new SavedGamesList();
        saveGameNameChecker = new SaveGameNameChecker(savedGamesList);
        this.saveMode = saveMode;

        addActionListeners();
        layoutComponents();
        adjustToMode();
    }

    private void addActionListeners() {

        gameInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                determineEnablingSaveButton();
            }
        });

        saveButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.saveButtonPressed(gameInputField.getText(), saveGameNameChecker);
            }
        });

        overWriteButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.overwriteButtonPressed(gameInputField.getText(), selectedGame.getText());
            }
        });

        loadGameButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.loadButtonPressed(gameInputField.getText());
            }
        });

        deleteButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.deleteButtonPressed(gameInputField.getText());
                savedGamesList.removeSelectedGameSlot();
                deleteButton.setVisible(!savedGamesList.isEmpty());
            }
        });

        cancelButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.cancelButtonPressed();
            }
        });
    }

    private void determineEnablingSaveButton() {
        saveButton.setEnabled(!gameInputField.getText().isBlank());
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel saveGamePanel = new JPanel(new FlowLayout());
        saveGamePanel.add(selectedGame);
        saveGamePanel.add(gameInputField);
        add(saveGamePanel, BorderLayout.NORTH);

        add(savedGamesList, BorderLayout.CENTER);
        savedGamesList.setSavedGamesListListener(new SaveGameListListenerImpl(this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(overWriteButton);
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
            gameInputField.setVisible(false);
            selectedGame.setText(Messages.getMessage("saveDialog.gameToLoad"));
        }

        overWriteButton.setVisible(false);
    }

    public void initializeGamesList() {
        savedGamesList.initializeList();
        if (savedGamesList.isEmpty()) {
            loadGameButton.setVisible(false);
            deleteButton.setVisible(false);
        }

        if (saveMode == SaveMode.SAVE) {
            savedGamesList.addEmptySlot();
        }

        gameInputField.setText(savedGamesList.getFirstGame());
    }

    public boolean isEmpty() {
        return savedGamesList.isEmpty();
    }

    public void setSaveDialogListener(SaveDialogListener saveDialogListener) {
        this.saveDialogListener = saveDialogListener;
    }

    public void savedGameSelected(GameSlot selectedGame) {
        gameInputField.setText(selectedGame.getName());
        if (saveMode == SaveMode.SAVE) {
            boolean isEmptySlot = savedGamesList.selectedGameIsEmptySlot();
            saveButton.setVisible(isEmptySlot);
            overWriteButton.setVisible(!isEmptySlot);
        }
    }

    public void savedGameDoubleClicked(GameSlot selectedGame) {
        savedGameSelected(selectedGame);
        saveDialogListener.savedGameDoubleClicked(selectedGame.getName());
    }
}
