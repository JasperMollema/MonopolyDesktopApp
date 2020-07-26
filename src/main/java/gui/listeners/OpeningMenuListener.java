package gui.listeners;

import gui.OpeningMenuView;

import java.util.EventListener;

public interface OpeningMenuListener extends EventListener {
    void newGameButtonClicked(OpeningMenuView openingMenuView);
}
