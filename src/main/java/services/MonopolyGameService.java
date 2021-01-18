package services;

import model.MonopolyBoardSpaces;
import model.MonopolyGame;
import model.Player;
import model.PlayerNameValidator;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGameService {
    private MonopolyGame monopolyGame;

    public void startMonopolyGame(List<String> playerNames) {
        if (!PlayerNameValidator.validatePlayers(playerNames)) {
            throw new RuntimeException("MonopolyGame : createPlayers() Player names are not valid!");
        }
        monopolyGame = new MonopolyGame(createPlayers(playerNames));
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
}
