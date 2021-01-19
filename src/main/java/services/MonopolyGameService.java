package services;

import model.MonopolyBoardSpaces;
import model.MonopolyGame;
import model.Player;
import model.PlayerNameValidator;
import valueObjects.MonopolyGameValueObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;
    private Map<String, String> playerPositions;

    public MonopolyGameService() {
        playerPositions = new HashMap<>();
    }

    public MonopolyGameValueObject startMonopolyGame(List<String> playerNames) {
        if (!PlayerNameValidator.validatePlayers(playerNames)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame = new MonopolyGame();
        monopolyGame.startGame(createPlayers(playerNames));
        putPlayersOnStart();

        MonopolyGameValueObject monopolyGameValueObject = new MonopolyGameValueObject();
        monopolyGameValueObject.playerPositions = playerPositions;
        monopolyGameValueObject.statusMessage = "controlPanel.playerCanThrowDice";
        monopolyGameValueObject.statusMessageArgs = new String[]{monopolyGame.getActivePlayer()};
        return monopolyGameValueObject;
    }

    private List<Player> createPlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        return players;
    }

    private void putPlayersOnStart() {
        List<Player> players = monopolyGame.getPlayers();
        players.stream().forEach(player -> playerPositions.put(player.toString(), MonopolyBoardSpaces.MESSAGE_RESOURCE_START));
    }

    public String[] getMonopolyBoardSpacesMessageResources() {
        return MonopolyBoardSpaces.getBoardNames();
    }
}
