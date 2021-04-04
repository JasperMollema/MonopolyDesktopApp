package services;

import model.*;
import util.Util;
import valueObjects.BoardSpaceValueObject;
import valueObjects.MonopolyGameValueObject;
import valueObjects.PlayerValueObject;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;
    private MonopolyGameValueObject monopolyGameValueObject;
    private MonopolyGameValueObjectMapper monopolyGameValueObjectMapper;
    private PlayerValueObjectMapper playerValueObjectMapper;
    private List <BoardSpaceValueObject> boardspaces;

    public MonopolyGameService() {
        monopolyGameValueObject = new MonopolyGameValueObject();
        boardspaces = createBoardSpaceValueObjects();
        monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
        playerValueObjectMapper = new PlayerValueObjectMapper();
    }

    public MonopolyGameValueObject startMonopolyGame(List<PlayerValueObject> players) {
        if (!PlayerNameValidator.validatePlayers(players)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame = new MonopolyGame();
        List<Player> playerList = playerValueObjectMapper.playerValueObjectsToPlayers(players);
        monopolyGame.startGame(Util.playerListToPlayerArray(playerList));
        monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
        return monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
    }

    public void loadMonopolyGame(MonopolyGameValueObject monopolyGameValueObject) {
        monopolyGame = monopolyGameValueObjectMapper.fillMonopolyGame(monopolyGameValueObject);
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
        return monopolyGameValueObjectMapper.fillValueObject(diceThrow, monopolyGame);
    }

    public MonopolyGameValueObject endTurn() {
        monopolyGame.endTurn();
        return monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
    }

    public MonopolyGameValueObject getMonopolyGameValueObject() {
        return monopolyGameValueObject;
    }

    public List<BoardSpaceValueObject> getBoardspaces() {
        return boardspaces;
    }
}
