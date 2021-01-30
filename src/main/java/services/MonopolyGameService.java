package services;

import model.*;
import valueObjects.BoardSpaceValueObject;
import valueObjects.MonopolyGameValueObject;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;
    private MonopolyGameValueObject monopolyGameValueObject;
    private MonopolyGameValueObjectMapper monopolyGameValueObjectMapper;

    public MonopolyGameService() {
        monopolyGameValueObject = new MonopolyGameValueObject();
        monopolyGameValueObject.boardSpaces = createBoardSpaceValueObjects();
        monopolyGame = new MonopolyGame();
        monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper(monopolyGameValueObject, monopolyGame);
    }

    public MonopolyGameValueObject startMonopolyGame(List<String> playerNames) {
        if (!PlayerNameValidator.validatePlayers(playerNames)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame.startGame(createPlayers(playerNames));
        monopolyGameValueObjectMapper.fillValueObject();
        return monopolyGameValueObjectMapper.fillValueObject();
    }

    private List<Player> createPlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        return players;
    }

    private List<BoardSpaceValueObject> createBoardSpaceValueObjects() {
        List<BoardSpaceValueObject> boardSpaceValueObjects = new ArrayList<>();
        String[] boardSpaceNames = MonopolyBoardSpaces.getBoardNames();
        for (int i = 0; i < boardSpaceNames.length; i++) {
            BoardSpaceValueObject boardSpaceValueObject = new BoardSpaceValueObject();
            boardSpaceValueObject.identifier = i;
            boardSpaceValueObject.name = boardSpaceNames[i];
            boardSpaceValueObjects.add(boardSpaceValueObject);
        }
        return boardSpaceValueObjects;
    }

    public MonopolyGameValueObject throwDice() {
        DiceThrower diceThrower = new DiceThrower();
        DiceThrow diceThrow = diceThrower.throwDice();

        monopolyGame.movePlayer(diceThrow);

        return monopolyGameValueObjectMapper.fillValueObject(diceThrow);
    }

    public MonopolyGameValueObject endTurn() {
        monopolyGame.endTurn();
        return monopolyGameValueObjectMapper.fillValueObject();
    }

    public MonopolyGameValueObject getMonopolyGameValueObject() {
        return monopolyGameValueObject;
    }
}
