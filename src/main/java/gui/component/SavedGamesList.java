package gui.component;

import gui.listeners.SavedGamesListListener;
import messages.Messages;
import services.SaveGamesService;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedGamesList extends JPanel {
    private JList<String> savedGamesList;
    private DefaultListModel<String> savedGamesModel;
    private SavedGamesListListener savedGamesListListener;

    public SavedGamesList() {
        savedGamesList = new JList<>();
        savedGamesModel = new DefaultListModel();

        savedGamesList.setModel(savedGamesModel);
        savedGamesList.setPreferredSize(new Dimension(300, 500));
        savedGamesList.setBorder(BorderFactory.createEtchedBorder());
        savedGamesList.addListSelectionListener(event -> {
            String gameToSave = (String) ((JList) event.getSource()).getSelectedValue();
            savedGamesListListener.savedGameSelected(gameToSave);
        });

        add(savedGamesList);
    }

    public void initializeList() {
        savedGamesModel.clear();
        List<String> savedGames = loadGames();
        for (String savedGame : savedGames) {
            savedGamesModel.addElement(savedGame);
        }
    }

    public void addGame(String name) {
        savedGamesModel.addElement(name);
    }

    public void removeGame(String name) {
        savedGamesModel.removeElement(name);
    }

    public void clearSelection() {
        savedGamesList.clearSelection();
    }

    public String determineTextNewGame() {
        Integer nrOfSavedGames = savedGamesModel.size();
        String textNewGame;
        do {
            String newGameNr = Util.stringValue(++nrOfSavedGames);
            textNewGame = Messages.getMessage("saveGamesList.newGame", newGameNr);
        }
        while (savedGamesModel.contains(textNewGame));
        return textNewGame;
    }

    private List<String> loadGames() {
        SaveGamesService saveGamesService = new SaveGamesService();
        List<String> savedGames = new ArrayList<>();
        try {
            savedGames = saveGamesService.loadGames();
        } catch (IOException ioException) {
            System.out.println("SavedGamesList : loadGames() failed to load games.");
        }
        return savedGames;
    }

    public String getNrOfSavedGames() {
        Integer nrOfSavedGames = savedGamesList.getSelectedValuesList().size();
        return nrOfSavedGames == null ? "1" : nrOfSavedGames.toString();
    }

    public void setSavedGamesListListener(SavedGamesListListener savedGamesListListener) {
        this.savedGamesListListener = savedGamesListListener;
    }

    public boolean isEmpty() {
        return savedGamesModel.isEmpty();
    }
}
