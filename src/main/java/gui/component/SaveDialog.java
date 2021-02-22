package gui.component;

import gui.MainFrame;
import gui.listeners.SaveDialogListener;
import gui.listeners.SaveGameListListenerImpl;
import messages.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class SaveDialog extends JDialog {
    private SavedGamesList savedGamesList;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton loadGameButton;
    private JButton deleteButton;
    private SaveDialogListener saveDialogListener;
    private JLabel selectedGame;
    private JTextField gameInputField;
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
        gameInputField = new JTextField(10);
        savedGamesList = new SavedGamesList();
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
            if (saveDialogListener != null && nameGameIsAllowed()) {
                saveDialogListener.saveButtonPressed(gameInputField.getText());
            }
        });

        loadGameButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.loadButtonPressed(gameInputField.getText());
            }
        });

        deleteButton.addActionListener(event -> {
            if (saveDialogListener != null && reallyDeleteGame(gameInputField.getText())) {
                saveDialogListener.deleteButtonPressed(gameInputField.getText());
                savedGamesList.removeGame(gameInputField.getText());
                deleteButton.setVisible(savedGamesList.isEmpty());
            }
        });

        cancelButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.cancelButtonPressed();
            }
        });
    }

    private boolean nameGameIsAllowed() {
        String nameGameToBeSaved = gameInputField.getText();
        if (nameEqualsEmptySlot()) {
            JOptionPane.showMessageDialog(
                    null,
                    Messages.getMessage("saveDialog.nameNotAllowed"),
                    Messages.getMessage("saveDialog.nameNotAllowed"),
                    JOptionPane.OK_OPTION);
            return false;
        }

        if (savedGamesList.nameIsInList(nameGameToBeSaved)) {
            int overwriteGame = JOptionPane.showConfirmDialog(
                    null,
                    Messages.getMessage("saveDialog.wantToOverWrite"),
                    Messages.getMessage("saveDialog.nameAlreadyExists"),
                    JOptionPane.OK_CANCEL_OPTION);
            return overwriteGame == JOptionPane.CANCEL_OPTION;
        }

        return true;
    }

    private boolean nameEqualsEmptySlot() {
        List<String> emptySlotValues = Messages.getAllValues("saveGamesList.emptySlot");
        for (String emptySlotValue : emptySlotValues) {
            if (emptySlotValue.equals(gameInputField.getText())) {
                return true;
            }
        }
        return false;
    }

    private void determineEnablingSaveButton() {
        saveButton.setEnabled(!gameInputField.getText().isBlank());
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
        saveGamePanel.add(gameInputField);
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
            gameInputField.setVisible(false);
            selectedGame.setText(Messages.getMessage("saveDialog.gameToLoad"));
        }
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
        saveButton.setText(Messages.getMessage(
                selectedGame.isEmptySlot() ? "saveDialog.save" : "saveDialog.overwrite"));
    }

    public void savedGameDoubleClicked(GameSlot selectedGame) {
        savedGameSelected(selectedGame);
        saveDialogListener.savedGameDoubleClicked(selectedGame.getName());
    }
}
