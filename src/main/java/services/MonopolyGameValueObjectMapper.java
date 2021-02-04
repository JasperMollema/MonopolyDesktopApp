package services;

import model.DiceThrow;
import model.MonopolyGame;
import util.Util;
import valueObjects.MonopolyGameValueObject;

public class MonopolyGameValueObjectMapper {
    MonopolyGameValueObject monopolyGameValueObject;
    MonopolyGame monopolyGame;

    public MonopolyGameValueObject fillValueObject(MonopolyGame monopolyGame) {
        monopolyGameValueObject = new MonopolyGameValueObject();
        monopolyGameValueObject.playerNames = Util.playersToPlayerNameList(monopolyGame.getPlayers());
        monopolyGameValueObject.playerPositions = Util.toStringIntegerMap(monopolyGame.getPlayerPositions());
        monopolyGameValueObject.activePlayer = monopolyGame.getActivePlayer().toString();
        return monopolyGameValueObject;
    }

    public MonopolyGameValueObject fillValueObject(DiceThrow diceThrow, MonopolyGame monopolyGame) {
        fillValueObject(monopolyGame);
        monopolyGameValueObject.diceThrow1 = Util.stringValue(diceThrow.getFirstDiceThrow());
        monopolyGameValueObject.diceThrow2 = Util.stringValue(diceThrow.getSecondDiceThrow());
        monopolyGameValueObject.canThrowAgain = monopolyGame.canPlayerThrowAgain();
        return monopolyGameValueObject;
    }

    public MonopolyGame fillMonopolyGame(MonopolyGameValueObject monopolyGameValueObject) {
        monopolyGame = new MonopolyGame();
        return monopolyGame;
    }
}
