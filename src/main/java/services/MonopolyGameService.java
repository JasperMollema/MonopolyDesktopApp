package services;

import model.MonopolyBoardSpaces;
import model.MonopolyGame;
import model.Player;
import model.PlayerNameValidator;
import valueObjects.MonopolyGameValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;


    public MonopolyGameValueObject startMonopolyGame(List<String> playerNames) {
        if (!PlayerNameValidator.validatePlayers(playerNames)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame = new MonopolyGame();
        monopolyGame.startGame(createPlayers(playerNames));

        MonopolyGameValueObject monopolyGameValueObject = new MonopolyGameValueObject();
        monopolyGameValueObject.playerPositions = monopolyGame.getPlayerPositions();
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

    public String[] getMonopolyBoardSpacesMessageResources() {
        return MonopolyBoardSpaces.getBoardNames();
    }

    public void throwDice() {
        Random random = new Random();
        int diceTrow = random.nextInt(11) + 1;

        monopolyGame.moveActivePlayer(diceTrow);
    }
}
