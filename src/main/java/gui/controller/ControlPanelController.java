package gui.controller;

import gui.listeners.ControlPanelListener;
import gui.view.ControlPanelView;

public class ControlPanelController extends AbstractController {
    private ControlPanelView controlPanelView;
    private ControlPanelListener controlPanelListener;

    public ControlPanelController(ControlPanelView controlPanelView) {
        this.controlPanelView = controlPanelView;
        addActionListeners();
    }

    private void addActionListeners() {
        controlPanelView.addActionListenerToThrowDiceButton(event -> controlPanelListener.throwDiceButtonPressed());
        controlPanelView.addActionListenerToStartTurnButton(event -> controlPanelListener.startTurnButtonPressed());
        controlPanelView.addActionListenerToEndTurnButton(event -> controlPanelListener.endTurnButtonPressed());
    }

    public void setControlPanelListener(ControlPanelListener controlPanelListener) {
        this.controlPanelListener = controlPanelListener;
    }

    public void fillInfoMessage1(String infoMessage, String[] args) {
        if (infoMessage != null) {
            controlPanelView.fillInfoMessage1(infoMessage, args);
        }
        controlPanelView.showInfoMessage1(infoMessage != null);
    }

    public void fillInfoMessage2(String infoMessage, String[] args) {
        if (infoMessage != null) {
            controlPanelView.fillInfoMessage2(infoMessage, args);
        }
        controlPanelView.showInfoMessage2(infoMessage != null);
    }

    public void enableStartTurnButton() {
        controlPanelView.enableStartTurnButton();
    }

    public void disableStartTurnButton() {
        controlPanelView.disableStartTurnButton();
    }

    public void enableEndTurnButton() {
        controlPanelView.enableEndTurnButton();
    }

    public void disableEndTurnButton() {
        controlPanelView.disableEndTurnButton();
    }

    public void enableThrowDiceButton() {
        controlPanelView.enableThrowDiceTurnButton();
    }

    public void disableThrowDiceButton() {
        controlPanelView.disableThrowDiceTurnButton();
    }

    @Override
    public String getControllerName() {
        return "ControlPanelController";
    }

    @Override
    public void startController() {

    }
}
