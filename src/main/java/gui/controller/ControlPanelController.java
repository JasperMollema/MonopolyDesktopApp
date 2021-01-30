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
        controlPanelView.fillInfoMessage1(infoMessage, args);
    }

    public void fillInfoMessage2(String infoMessage, String[] args) {
        controlPanelView.fillInfoMessage2(infoMessage, args);
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

    public void showInfoMessage1() {
        controlPanelView.showInfoMessage1();
    }

    public void hideInfoMessage1() {
        controlPanelView.hideInfoMessage1();
    }

    public void showInfoMessage2() {
        controlPanelView.showInfoMessage2();
    }

    public void hideInfoMessage2() {
        controlPanelView.hideInfoMessage2();
    }

    @Override
    public String getControllerName() {
        return "ControlPanelController";
    }

    @Override
    public void startController() {

    }
}
