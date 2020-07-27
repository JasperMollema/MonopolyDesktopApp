package gui.controller;

import gui.component.NrOfPlayersComboBox;
import gui.view.AbstractView;
import gui.view.SelectNumberOfPlayersView;

public class SelectNumberOfPlayersController extends AbstractController {
    private final int DEFAULT_NR_OF_PLAYERS = 4;
    private SelectNumberOfPlayersView selectNumberOfPlayersView;

    @Override
    public void setView(AbstractView view) {
        selectNumberOfPlayersView = (SelectNumberOfPlayersView) view;
        selectNumberOfPlayersView.setVisible(true);
        addActionListeners();
    }

    private void addActionListeners() {
        addActionListenerStartGameBtn();
        addActionListenerNrOfPlayerComboBox();
    }

    private void showSelectNumberOfPlayers() {
        selectNumberOfPlayersView.setVisibilityStartGameBtn(false);
        selectNumberOfPlayersView.setVisibilityNrOfPlayersComboBox(true);
        selectNumberOfPlayersView.setNrOfPlayersSelected("4 players");
        setNrOfPlayerFieldsShown(DEFAULT_NR_OF_PLAYERS);
    }

    private void addActionListenerStartGameBtn() {
        selectNumberOfPlayersView.addActionListenerStartGameBtn((event) -> showSelectNumberOfPlayers());
    }

    private void addActionListenerNrOfPlayerComboBox() {
        selectNumberOfPlayersView.addActionListenerNrOfPlayersComboBox(event -> {
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
        selectNumberOfPlayersView.setVisibilityPlayer1Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer2Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer3Fields(false);
        selectNumberOfPlayersView.setVisibilityPlayer4Fields(false);
        selectNumberOfPlayersView.setVisibilityPlayer5Fields(false);
        selectNumberOfPlayersView.setVisibilityPlayer6Fields(false);
    }

    private void showThreePlayerFields() {
        selectNumberOfPlayersView.setVisibilityPlayer1Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer2Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer3Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer4Fields(false);
        selectNumberOfPlayersView.setVisibilityPlayer5Fields(false);
        selectNumberOfPlayersView.setVisibilityPlayer6Fields(false);

    }

    private void showFourPlayerFields() {
        selectNumberOfPlayersView.setVisibilityPlayer1Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer2Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer3Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer4Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer5Fields(false);
        selectNumberOfPlayersView.setVisibilityPlayer6Fields(false);
    }

    private void showFivePlayerFields() {
        selectNumberOfPlayersView.setVisibilityPlayer1Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer2Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer3Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer4Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer5Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer6Fields(false);
    }

    private void showSixPlayerFields() {
        selectNumberOfPlayersView.setVisibilityPlayer1Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer2Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer3Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer4Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer5Fields(true);
        selectNumberOfPlayersView.setVisibilityPlayer6Fields(true);
    }
}
