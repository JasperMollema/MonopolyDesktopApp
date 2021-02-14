package gui.listeners;

import gui.controller.ControlPanelController;
import gui.controller.MonopolyGameController;
import services.MonopolyGameService;
import valueObjects.MonopolyGameValueObject;

public class ControlPanelListenerImpl implements ControlPanelListener {
    private MonopolyGameController monopolyGameController;
    private ControlPanelController controlPanelController;
    private MonopolyGameService monopolyGameService;
    private MonopolyGameValueObject monopolyGameValueObject;

    public ControlPanelListenerImpl(MonopolyGameController monopolyGameController, ControlPanelController controlPanelController, MonopolyGameService monopolyGameService) {
        this.monopolyGameController = monopolyGameController;
        this.controlPanelController = controlPanelController;
        this.monopolyGameService = monopolyGameService;
    }

    @Override
    public void startTurnButtonPressed() {
        clearMessages();
        String activePlayer = monopolyGameController.getMonopolyGameValueObject().activePlayer;
        controlPanelController.fillInfoMessage1("controlPanel.playerCanThrowDice", new String[]{activePlayer});
        controlPanelController.disableStartTurnButton();
        controlPanelController.enableThrowDiceButton();
    }

    @Override
    public void endTurnButtonPressed() {
        clearMessages();
        monopolyGameValueObject = monopolyGameService.endTurn();
        controlPanelController.fillInfoMessage1("controlPanel.playerTurn", new String[]{monopolyGameValueObject.activePlayer});
        controlPanelController.enableStartTurnButton();
        controlPanelController.disableEndTurnButton();
        controlPanelController.disableThrowDiceButton();
        monopolyGameController.setMonopolyGameValueObject(monopolyGameValueObject);
    }

    @Override
    public void throwDiceButtonPressed() {
        clearMessages();
        monopolyGameValueObject = monopolyGameService.throwDice();
        movePlayer();
        fillMessagesAfterDiceThrow();

        if (!monopolyGameValueObject.canThrowAgain) {
            controlPanelController.disableThrowDiceButton();
            controlPanelController.enableEndTurnButton();
        }

        monopolyGameController.setMonopolyGameValueObject(monopolyGameValueObject);
    }

    private void movePlayer() {
        String player = monopolyGameValueObject.activePlayer;
        int newPlayerPosition = monopolyGameValueObject.playerPositions.get(player);
        monopolyGameController.movePlayer(player, newPlayerPosition);
    }

    private void fillMessagesAfterDiceThrow() {
        fillResultDiceThrowMessage();
        if (monopolyGameValueObject.canThrowAgain) {
            fillThrowAgainMessage();
        } else fillCanNotThrowAgainMessage();
    }

    private void fillResultDiceThrowMessage() {
        controlPanelController.fillInfoMessage1(
                "controlPanel.resultDiceThrow",
                new String[]{monopolyGameValueObject.activePlayer, monopolyGameValueObject.diceThrow1, monopolyGameValueObject.diceThrow2}
        );
    }

    private void fillThrowAgainMessage() {
        controlPanelController.fillInfoMessage2("controlPanel.playerCanThrowAgain", new String[]{monopolyGameValueObject.activePlayer});
    }

    private void fillCanNotThrowAgainMessage() {
        controlPanelController.fillInfoMessage2("controlPanel.playerCanNotThrowAgain", new String[]{monopolyGameValueObject.activePlayer});
    }

    private void clearMessages() {
        controlPanelController.fillInfoMessage1(null, null);
        controlPanelController.fillInfoMessage2(null, null);
    }
}
