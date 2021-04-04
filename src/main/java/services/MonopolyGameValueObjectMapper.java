package services;

import model.DiceThrow;
import model.MonopolyGame;
import model.Player;
import util.Util;
import valueObjects.MonopolyGameValueObject;

import java.util.List;

public class MonopolyGameValueObjectMapper {
    MonopolyGameValueObject monopolyGameValueObject;
    MonopolyGame monopolyGame;
    PlayerValueObjectMapper playerValueObjectMapper;

    public MonopolyGameValueObjectMapper() {
        playerValueObjectMapper = new PlayerValueObjectMapper();
    }

    public MonopolyGameValueObject fillValueObject(MonopolyGame monopolyGame) {
        monopolyGameValueObject = new MonopolyGameValueObject();
        List<Player> playerList = Util.playerArrayToPlayerList(monopolyGame.getPlayers());
        monopolyGameValueObject.players = playerValueObjectMapper.playersToPlayerValueObjects(playerList);
        monopolyGameValueObject.playerPositions = Util.toStringIntegerMap(monopolyGame.getPlayerPositions());
        monopolyGameValueObject.activePlayer = monopolyGame.getActivePlayer().toString();
        monopolyGameValueObject.nrOfDiceThrowsActivePlayer = monopolyGame.getNrOfDiceThrowsActivePlayer();
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
        List<Player> playerList = playerValueObjectMapper.playerValueObjectsToPlayers(monopolyGameValueObject.players);
        monopolyGame.setPlayers(Util.playerListToPlayerArray(playerList));
        monopolyGame.setPlayerPositions(Util.toPlayerIntegerMap(monopolyGameValueObject.playerPositions));
        monopolyGame.fillActivePlayer(monopolyGameValueObject.activePlayer);
        monopolyGame.setCanPlayerThrowAgain(Util.notNullBoolean(monopolyGameValueObject.canThrowAgain));
        monopolyGame.setNrOfDiceThrowsActivePlayer(Util.notNullInteger(monopolyGameValueObject.nrOfDiceThrowsActivePlayer));

        return monopolyGame;
    }
}
