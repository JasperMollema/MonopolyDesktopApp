package gui.listeners;

import java.util.EventListener;

public interface MainMenuListener extends EventListener {
    void newGameButtonPressed();
    void loadGameButtonPressed();
    void languageButtonPressed();
}
