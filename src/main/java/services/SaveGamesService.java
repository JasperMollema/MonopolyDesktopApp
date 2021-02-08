package services;

import model.MonopolyGame;
import model.MonopolyGameSaver;
import valueObjects.MonopolyGameValueObject;

import java.io.IOException;
import java.util.List;

public class SaveGamesService {
    private MonopolyGameSaver monopolyGameSaver;
    private MonopolyGameValueObjectMapper monopolyGameValueObjectMapper;

    public SaveGamesService() {
        monopolyGameSaver = new MonopolyGameSaver();
        monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
    }

    public void save(String nameGame, MonopolyGameValueObject monopolyGameValueObject) throws IOException {
        MonopolyGame monopolyGame = monopolyGameValueObjectMapper.fillMonopolyGame(monopolyGameValueObject);
        monopolyGameSaver.saveMonopolyGame(monopolyGame, nameGame);
    }

    public List<String> loadGames() throws IOException {
        return monopolyGameSaver.loadGames();
    }

    public MonopolyGameValueObject loadGame(String nameGame) throws IOException, ClassNotFoundException {
        MonopolyGame monopolyGame = monopolyGameSaver.loadMonopolyGame(nameGame);
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
        return monopolyGameValueObject;
    }
}
