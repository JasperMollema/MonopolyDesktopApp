package gui.component;

import gui.listeners.SavedGamesListListener;
import services.SaveGamesService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SavedGamesList extends JPanel {
    private JList<String> savedGamesList;
    private SavedGamesListListener savedGamesListListener;

    public SavedGamesList() {
        savedGamesList = new JList<>();
        SaveGamesService saveGamesService = new SaveGamesService();
        DefaultListModel<String> savedGamesModel = new DefaultListModel();
        List<String> savedGames = saveGamesService.getSavedGames();
        if (savedGames.isEmpty()) {
            savedGamesList.setVisible(false);
        }
        for (String savedGame : savedGames) {
            savedGamesModel.addElement(savedGame);
        }

        savedGamesList.setModel(savedGamesModel);
        savedGamesList.setPreferredSize(new Dimension(300, 500));
        savedGamesList.setBorder(BorderFactory.createEtchedBorder());
        savedGamesList.addListSelectionListener(event -> {
            String gameToSave = (String) ((JList) event.getSource()).getSelectedValue();
            savedGamesListListener.savedGameSelected(gameToSave);
        });

        add(savedGamesList);
    }

    public String getNrOfSavedGames() {
        Integer nrOfSavedGames = savedGamesList.getSelectedValuesList().size();
        return nrOfSavedGames == null ? "1" : nrOfSavedGames.toString();
    }

    public void setSavedGamesListListener(SavedGamesListListener savedGamesListListener) {
        this.savedGamesListListener = savedGamesListListener;
    }
}
