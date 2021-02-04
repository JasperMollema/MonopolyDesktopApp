package services;

import model.MonopolyGame;
import model.MonopolyGameSaver;
import valueObjects.MonopolyGameValueObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SaveGamesService {
    private MonopolyGameSaver monopolyGameSaver;
    private MonopolyGameValueObjectMapper monopolyGameValueObjectMapper;

    public SaveGamesService() {
        monopolyGameSaver = new MonopolyGameSaver();
        monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
    }

    public void save(String nameGame, MonopolyGameValueObject monopolyGameValueObject) throws IOException {
        MonopolyGameSaver monopolyGameSaver = new MonopolyGameSaver();
        MonopolyGameValueObjectMapper monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
        MonopolyGame monopolyGame = monopolyGameValueObjectMapper.fillMonopolyGame(monopolyGameValueObject);
        monopolyGameSaver.saveMonopolyGame(monopolyGame, nameGame);
    }

    public MonopolyGameValueObject loadGame(String nameGame) throws IOException {
        MonopolyGameSaver monopolyGameSaver = new MonopolyGameSaver();
        MonopolyGameValueObjectMapper monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
        return new MonopolyGameValueObject();
    }

    public List<String> getSavedGames() {
        List<String> savedGames = Arrays.asList("saved game 1", "saved game 2", "saved game 3", "saved game 4", "saved game 5");
        return savedGames;
    }
}
