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
    }

    public void setControlPanelListener(ControlPanelListener controlPanelListener) {
        this.controlPanelListener = controlPanelListener;
    }

    public void fillStatusMessage(String statusMessage, String[] args) {
        controlPanelView.fillStatusMessage(statusMessage, args);
    }

    @Override
    public String getControllerName() {
        return "ControlPanelController";
    }

    @Override
    public void startController() {

    }
}
