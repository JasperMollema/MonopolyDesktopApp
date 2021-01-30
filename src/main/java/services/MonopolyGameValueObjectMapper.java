package services;

import model.DiceThrow;
import model.MonopolyGame;
import util.Util;
import valueObjects.MonopolyGameValueObject;

public class MonopolyGameValueObjectMapper {
    private MonopolyGameValueObject monopolyGameValueObject;
    private MonopolyGame monopolyGame;

    public MonopolyGameValueObjectMapper(MonopolyGameValueObject monopolyGameValueObject, MonopolyGame monopolyGame) {
        this.monopolyGameValueObject = monopolyGameValueObject;
        this.monopolyGame = monopolyGame;
    }

    public MonopolyGameValueObject fillValueObject() {
        monopolyGameValueObject.playerPositions = Util.toStringIntegerMap(monopolyGame.getPlayerPositions());
        monopolyGameValueObject.activePlayer = monopolyGame.getActivePlayer().toString();
        return monopolyGameValueObject;
    }

    public MonopolyGameValueObject fillValueObject(DiceThrow diceThrow) {
        fillValueObject();
        monopolyGameValueObject.diceThrow1 = Util.stringValue(diceThrow.getFirstDiceThrow());
        monopolyGameValueObject.diceThrow2 = Util.stringValue(diceThrow.getSecondDiceThrow());
        monopolyGameValueObject.canThrowAgain = monopolyGame.canPlayerThrowAgain();
        return monopolyGameValueObject;
    }
}
