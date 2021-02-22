package gui.component;

import gui.listeners.SavedGamesListListener;
import services.SaveGamesService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SavedGamesList extends JPanel {
    private JList<GameSlot> gameSlots;
    private DefaultListModel<GameSlot> savedGamesModel;
    private SavedGamesListListener savedGamesListListener;

    public SavedGamesList() {
        gameSlots = new JList<>();
        savedGamesModel = new DefaultListModel();

        gameSlots.setModel(savedGamesModel);
        gameSlots.setPreferredSize(new Dimension(300, 500));
        gameSlots.setBorder(BorderFactory.createEtchedBorder());
        gameSlots.setBackground(Color.BLACK);
        gameSlots.setCellRenderer(new GameSlotRenderer());

        gameSlots.addListSelectionListener(event -> {
            GameSlot gameToSave = gameSlots.getSelectedValue();
            if (gameToSave != null) {
                savedGamesListListener.savedGameSelected(gameToSave);
            }
        });

        gameSlots.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    savedGamesListListener.saveGameDoubleClicked(gameSlots.getSelectedValue());
                }
            }
        });

        add(gameSlots);
    }

    public void initializeList() {
        savedGamesModel.clear();
        List<String> savedGames = loadGames();
        for (String savedGame : savedGames) {
            savedGamesModel.addElement(new GameSlot(savedGame));
        }
    }

    public boolean nameIsInList(String nameGame) {
        boolean containsGame = false;
        Iterator<GameSlot> gameSlotIterator = savedGamesModel.elements().asIterator();
        while (gameSlotIterator.hasNext() && !containsGame) {
            String nameGameSlot = gameSlotIterator.next().getName();
            containsGame = nameGameSlot.equals(nameGame);
        }
        return containsGame;
    }

    public void addEmptySlot() {
        savedGamesModel.add(0, new GameSlot("Empty Slot", true));
        gameSlots.setSelectedIndex(0);
    }

    public String getFirstGame() {
        return savedGamesModel.firstElement().getName();
    }

    public void removeGame(String name) {
        savedGamesModel.removeElement(name);
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

    public void setSavedGamesListListener(SavedGamesListListener savedGamesListListener) {
        this.savedGamesListListener = savedGamesListListener;
    }

    public boolean isEmpty() {
        return savedGamesModel.isEmpty();
    }
}
