package gui.listeners;

import gui.controller.ControlPanelController;
import gui.controller.MonopolyGameController;
import services.MonopolyGameService;
import valueObjects.MonopolyGameValueObject;

import java.util.Map;

public class ControlPanelListenerImpl implements ControlPanelListener {
    private MonopolyGameController monopolyGameController;
    private ControlPanelController controlPanelController;
    private MonopolyGameService monopolyGameService;

    public ControlPanelListenerImpl(MonopolyGameController monopolyGameController, ControlPanelController controlPanelController, MonopolyGameService monopolyGameService) {
        this.monopolyGameController = monopolyGameController;
        this.controlPanelController = controlPanelController;
        this.monopolyGameService = monopolyGameService;
    }

    @Override
    public void throwDiceButtonPressed() {
        // Throw dice
        // Move player
        // change message in player has thrown
        // show button end turn
        // pass on move to next player.

        // Let model know a dice have been thrown or to throw a dice.
        String activePlayer = monopolyGameService.getMonopolyGameValueObject().activePlayer;
        Map<String, Integer> playerPositions = monopolyGameService.getMonopolyGameValueObject().playerPositions;
        int oldPosition = playerPositions.get(activePlayer);

        MonopolyGameValueObject monopolyGameValueObject = monopolyGameService.throwDice();
        controlPanelController.fillStatusMessage(monopolyGameValueObject.statusMessage, monopolyGameValueObject.statusMessageArgs);

        int newPosition = monopolyGameValueObject.playerPositions.get(activePlayer);

        monopolyGameController.movePlayer(activePlayer, oldPosition, newPosition);
    }
}
