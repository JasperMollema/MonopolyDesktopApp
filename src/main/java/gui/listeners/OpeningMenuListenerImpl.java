package gui.listeners;

import gui.OpeningMenuView;

public class OpeningMenuListenerImpl implements OpeningMenuListener {
    @Override
    public void newGameButtonClicked(OpeningMenuView openingMenuView) {
        openingMenuView.setVisibilityStartGameBtn(false);
        openingMenuView.setVisibilityNrOfPlayersComboBox(true);
    }
}
