package services;

import gui.component.GameSlot;
import model.MonopolyGame;
import model.MonopolyGameSaver;
import valueObjects.MonopolyGameValueObject;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaveGamesService {
    private MonopolyGameSaver monopolyGameSaver;
    private MonopolyGameValueObjectMapper monopolyGameValueObjectMapper;

    public SaveGamesService() {
        monopolyGameSaver = new MonopolyGameSaver();
        monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
    }

    public void saveGame(String nameGame, MonopolyGameValueObject monopolyGameValueObject) throws IOException {
        MonopolyGame monopolyGame = monopolyGameValueObjectMapper.fillMonopolyGame(monopolyGameValueObject);
        monopolyGameSaver.saveMonopolyGame(monopolyGame, nameGame);
    }

    public List<GameSlot> loadGames() throws IOException {
        List<GameSlot> gameSlots = new ArrayList<>();
        Map<String, BasicFileAttributes> loadedGames = monopolyGameSaver.loadGames();
        for (String loadedGame : loadedGames.keySet()) {
            FileTime fileTime = loadedGames.get(loadedGame).lastModifiedTime();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
            gameSlots.add(new GameSlot(loadedGame, localDateTime));
        }

        return gameSlots;
    }

    public MonopolyGameValueObject loadGame(String nameGame) throws IOException, ClassNotFoundException {
        MonopolyGame monopolyGame = monopolyGameSaver.loadMonopolyGame(nameGame);
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
        return monopolyGameValueObject;
    }

    public void deleteGame(String nameGame) throws IOException {
        monopolyGameSaver.deleteMonopolyGame(nameGame);
    }
}
