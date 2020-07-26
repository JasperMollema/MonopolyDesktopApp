package gui;

import javax.swing.*;

public class OpeningMenuController {
    private final int DEFAULT_NR_OF_PLAYERS = 4;
    private OpeningMenuView openingMenuView;

    public OpeningMenuController(OpeningMenuView openingMenuView) {
        this.openingMenuView = openingMenuView;
        addActionListeners();
    }

    private void showSelectNumberOfPlayers() {
        openingMenuView.setVisibilityStartGameBtn(false);
        openingMenuView.setVisibilityNrOfPlayersComboBox(true);
        openingMenuView.setNrOfPlayersSelected("4 players");
        setNrOfPlayerFieldsShown(DEFAULT_NR_OF_PLAYERS);
    }

    private void addActionListeners() {
        addActionListenerStartGameBtn();
        addActionListenerNrOfPlayerComboBox();
    }

    private void addActionListenerStartGameBtn() {
        openingMenuView.addActionListenerStartGameBtn((event) -> showSelectNumberOfPlayers());
    }

    private void addActionListenerNrOfPlayerComboBox() {
        openingMenuView.addActionListenerNrOfPlayersComboBox(event -> {
            NrOfPlayersComboBox nrOfPlayersComboBox = (NrOfPlayersComboBox) event.getSource();
            int nrOfPlayers = nrOfPlayersComboBox.getNrOfPlayersSelected();
            setNrOfPlayerFieldsShown(nrOfPlayers);
        });
    }

    private void setNrOfPlayerFieldsShown(int nrOfFields) {
        if (nrOfFields == 2) {
            showTwoPlayerFields();
        }
        else if (nrOfFields ==3) {
            showThreePlayerFields();
        }
        else if (nrOfFields ==4) {
            showFourPlayerFields();
        }
        else if (nrOfFields ==5) {
            showFivePlayerFields();
        }
        else if (nrOfFields ==6) {
            showSixPlayerFields();
        }
    }

    private void showTwoPlayerFields() {
        openingMenuView.setVisibilityPlayer1Fields(true);
        openingMenuView.setVisibilityPlayer2Fields(true);
        openingMenuView.setVisibilityPlayer3Fields(false);
        openingMenuView.setVisibilityPlayer4Fields(false);
        openingMenuView.setVisibilityPlayer5Fields(false);
        openingMenuView.setVisibilityPlayer6Fields(false);
    }

    private void showThreePlayerFields() {
        openingMenuView.setVisibilityPlayer1Fields(true);
        openingMenuView.setVisibilityPlayer2Fields(true);
        openingMenuView.setVisibilityPlayer3Fields(true);
        openingMenuView.setVisibilityPlayer4Fields(false);
        openingMenuView.setVisibilityPlayer5Fields(false);
        openingMenuView.setVisibilityPlayer6Fields(false);

    }

    private void showFourPlayerFields() {
        openingMenuView.setVisibilityPlayer1Fields(true);
        openingMenuView.setVisibilityPlayer2Fields(true);
        openingMenuView.setVisibilityPlayer3Fields(true);
        openingMenuView.setVisibilityPlayer4Fields(true);
        openingMenuView.setVisibilityPlayer5Fields(false);
        openingMenuView.setVisibilityPlayer6Fields(false);
    }

    private void showFivePlayerFields() {
        openingMenuView.setVisibilityPlayer1Fields(true);
        openingMenuView.setVisibilityPlayer2Fields(true);
        openingMenuView.setVisibilityPlayer3Fields(true);
        openingMenuView.setVisibilityPlayer4Fields(true);
        openingMenuView.setVisibilityPlayer5Fields(true);
        openingMenuView.setVisibilityPlayer6Fields(false);
    }

    private void showSixPlayerFields() {
        openingMenuView.setVisibilityPlayer1Fields(true);
        openingMenuView.setVisibilityPlayer2Fields(true);
        openingMenuView.setVisibilityPlayer3Fields(true);
        openingMenuView.setVisibilityPlayer4Fields(true);
        openingMenuView.setVisibilityPlayer5Fields(true);
        openingMenuView.setVisibilityPlayer6Fields(true);
    }
}
