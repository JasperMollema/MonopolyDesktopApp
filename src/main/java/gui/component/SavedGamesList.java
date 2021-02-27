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
    private DefaultListModel<GameSlot> gameSlotsModel;
    private SavedGamesListListener savedGamesListListener;

    public SavedGamesList() {
        gameSlots = new JList<>();
        gameSlotsModel = new DefaultListModel();

        gameSlots.setModel(gameSlotsModel);
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
        gameSlotsModel.clear();
        List<GameSlot> savedGames = loadGames();
        for (GameSlot savedGame : savedGames) {
            gameSlotsModel.addElement(savedGame);
        }
    }

    public boolean nameIsInList(String nameGame) {
        boolean containsGame = false;
        Iterator<GameSlot> gameSlotIterator = gameSlotsModel.elements().asIterator();
        while (gameSlotIterator.hasNext() && !containsGame) {
            String nameGameSlot = gameSlotIterator.next().getName();
            containsGame = nameGameSlot.equals(nameGame);
        }
        return containsGame;
    }

    public void addEmptySlot() {
        gameSlotsModel.add(0, new GameSlot("Empty Slot", true));
        gameSlots.setSelectedIndex(0);
    }

    public String getFirstGame() {
        if (!gameSlotsModel.isEmpty()) {
            return gameSlotsModel.firstElement().getName();
        }
        return "";
    }

    public boolean selectedGameIsEmptySlot() {
        return gameSlots.getSelectedValue().isEmptySlot();
    }

    public void removeSelectedGameSlot() {

        boolean removed = gameSlotsModel.removeElement((gameSlots.getSelectedValue()));
        System.out.println("Game removed : " + removed);
    }

    private List<GameSlot> loadGames() {
        SaveGamesService saveGamesService = new SaveGamesService();
        List<GameSlot> savedGames = new ArrayList<>();
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
        return gameSlotsModel.isEmpty();
    }
}
