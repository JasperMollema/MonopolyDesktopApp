package gui.listeners;

import java.util.EventListener;

public interface ControlPanelListener extends EventListener {
    void throwDiceButtonPressed();
    void startTurnButtonPressed();
    void endTurnButtonPressed();
}
