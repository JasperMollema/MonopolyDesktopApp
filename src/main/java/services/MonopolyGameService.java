package services;

import model.MonopolyBoardSpaces;
import model.MonopolyGame;
import model.Player;
import model.PlayerNameValidator;
import valueObjects.BoardSpaceValueObject;
import valueObjects.MonopolyGameValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;
    private MonopolyGameValueObject monopolyGameValueObject;

    public MonopolyGameService() {
        monopolyGameValueObject = new MonopolyGameValueObject();
    }

    public MonopolyGameValueObject startMonopolyGame(List<String> playerNames) {
        if (!PlayerNameValidator.validatePlayers(playerNames)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame = new MonopolyGame();
        monopolyGame.startGame(createPlayers(playerNames));

        monopolyGameValueObject.playerPositions = monopolyGame.getPlayerPositions();
        monopolyGameValueObject.statusMessage = "controlPanel.playerCanThrowDice";
        monopolyGameValueObject.statusMessageArgs = new String[]{monopolyGame.getActivePlayer()};
        monopolyGameValueObject.boardSpaces = createBoardSpaceValueObjects();
        monopolyGameValueObject.activePlayer = monopolyGame.getActivePlayer();
        return monopolyGameValueObject;
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
        Random random = new Random();
        int diceTrow = random.nextInt(11) + 1;

        monopolyGame.moveActivePlayer(diceTrow);
        monopolyGameValueObject.playerPositions = monopolyGame.getPlayerPositions();
        monopolyGameValueObject.statusMessageArgs = new String[]{monopolyGame.getActivePlayer()};
        monopolyGameValueObject.activePlayer = monopolyGame.getActivePlayer();
        return monopolyGameValueObject;
    }

    public MonopolyGameValueObject getMonopolyGameValueObject() {
        return monopolyGameValueObject;
    }
}
