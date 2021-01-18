package gui.controller;

import gui.view.ControlPanelView;

public class ControlPanelController extends AbstractController {
    private ControlPanelView controlPanelView;

    public ControlPanelController(ControlPanelView controlPanelView) {
        this.controlPanelView = controlPanelView;
    }

    @Override
    public String getControllerName() {
        return "ControlPanelController";
    }

    @Override
    public void startController() {

    }
}
