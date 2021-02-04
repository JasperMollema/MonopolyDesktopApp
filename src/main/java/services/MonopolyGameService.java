package services;

import model.*;
import util.Util;
import valueObjects.BoardSpaceValueObject;
import valueObjects.MonopolyGameValueObject;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;
    private MonopolyGameValueObject monopolyGameValueObject;
    private MonopolyGameValueObjectMapper monopolyGameValueObjectMapper;
    private List <BoardSpaceValueObject> boardspaces;

    public MonopolyGameService() {
        monopolyGameValueObject = new MonopolyGameValueObject();
        boardspaces = createBoardSpaceValueObjects();
        monopolyGame = new MonopolyGame();
        monopolyGameValueObjectMapper = new MonopolyGameValueObjectMapper();
    }

    public MonopolyGameValueObject startMonopolyGame(List<String> playerNames) {
        if (!PlayerNameValidator.validatePlayers(playerNames)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame.startGame(Util.playerNamesToPlayerArray(playerNames));
        monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
        return monopolyGameValueObjectMapper.fillValueObject(monopolyGame);
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
