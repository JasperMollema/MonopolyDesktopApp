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
    public void startTurnButtonPressed() {
        hideMessages();
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameController.getMonopolyGameValueObject();
        controlPanelController.fillInfoMessage1("controlPanel.playerCanThrowDice", new String[]{monopolyGameValueObject.activePlayer});
        controlPanelController.showInfoMessage1();
        controlPanelController.disableStartTurnButton();
        controlPanelController.enableThrowDiceButton();
        monopolyGameController.setMonopolyGameValueObject(monopolyGameValueObject);
    }

    @Override
    public void endTurnButtonPressed() {
        hideMessages();
        MonopolyGameValueObject monopolyGameValueObject = monopolyGameService.endTurn();
        controlPanelController.fillInfoMessage1("controlPanel.playerTurn", new String[]{monopolyGameValueObject.activePlayer});
        controlPanelController.enableStartTurnButton();
        controlPanelController.disableEndTurnButton();
        controlPanelController.disableThrowDiceButton();
        monopolyGameController.setMonopolyGameValueObject(monopolyGameValueObject);
    }

    @Override
    public void throwDiceButtonPressed() {
        hideMessages();
        MonopolyGameValueObject beforeDiceThrow = monopolyGameController.getMonopolyGameValueObject();
        String currentActivePlayer = beforeDiceThrow.activePlayer;
        Map<String, Integer> playerPositions = beforeDiceThrow.playerPositions;
        int oldPosition = playerPositions.get(currentActivePlayer);

        MonopolyGameValueObject afterDiceThrow = monopolyGameService.throwDice();
        int newPosition = afterDiceThrow.playerPositions.get(currentActivePlayer);
        monopolyGameController.movePlayer(currentActivePlayer, oldPosition, newPosition);
        controlPanelController.fillInfoMessage1("controlPanel.resultDiceThrow",
                new String[]{currentActivePlayer, afterDiceThrow.diceThrow1, afterDiceThrow.diceThrow2});
        controlPanelController.showInfoMessage1();
        if (afterDiceThrow.canThrowAgain) {
            controlPanelController.fillInfoMessage2("controlPanel.playerCanThrowAgain", new String[]{currentActivePlayer});
        } else {
            controlPanelController.fillInfoMessage2("controlPanel.playerCanNotThrowAgain", new String[]{currentActivePlayer});
            controlPanelController.disableThrowDiceButton();
            controlPanelController.enableEndTurnButton();
        }
        controlPanelController.showInfoMessage2();
        monopolyGameController.setMonopolyGameValueObject(afterDiceThrow);
    }

    private void hideMessages() {
        controlPanelController.hideInfoMessage1();
        controlPanelController.hideInfoMessage2();
    }
}
