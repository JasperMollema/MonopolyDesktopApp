package services;

import model.Player;
import valueObjects.PlayerValueObject;

import java.util.ArrayList;
import java.util.List;

public class PlayerValueObjectMapper {

    public List<Player> playerValueObjectsToPlayers(List<PlayerValueObject> playerValueObjects) {
        List<Player> players = new ArrayList<>();
        for (PlayerValueObject playerValueObject : playerValueObjects) {
            players.add(new Player(
                    playerValueObject.name,
                    playerValueObject.playerColor,
                    playerValueObject.isComputer
            ));
        }
        return players;
    }

    public List<PlayerValueObject> playersToPlayerValueObjects(List<Player> players) {
        List<PlayerValueObject> playerValueObjects = new ArrayList<>();
        for (Player player : players) {
            PlayerValueObject playerValueObject = new PlayerValueObject();
            playerValueObject.name = player.getName();
            playerValueObject.playerColor = player.getColor();
            playerValueObject.isComputer = player.isComputer();
            playerValueObjects.add(playerValueObject);
        }
        return playerValueObjects;
    }
}
