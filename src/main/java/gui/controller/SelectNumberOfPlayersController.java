package gui.controller;

import gui.component.NrOfPlayersComboBox;
import gui.listeners.SelectNumberOfPlayersListener;
import gui.view.SelectNumberOfPlayersView;

public class SelectNumberOfPlayersController extends AbstractController {
    private final String NAME_CONTROLLER = "SelectNumberOfPlayersController";
    private final Integer DEFAULT_NR_OF_PLAYERS = 4;

    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private SelectNumberOfPlayersListener selectNumberOfPlayersListener;

    public SelectNumberOfPlayersController(SelectNumberOfPlayersView selectNumberOfPlayersView) {
        this.selectNumberOfPlayersView = selectNumberOfPlayersView;
        addActionListeners();
    }

    @Override
    public void startController() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        selectNumberOfPlayersView.setNrOfPlayersSelected(DEFAULT_NR_OF_PLAYERS);
    }

    private void addActionListeners() {
        addActionListenerNrOfPlayerComboBox();
        addActionListenerStartGameButton();
        addActionListenerGoToMainMenuButton();
    }

    private void addActionListenerNrOfPlayerComboBox() {
        selectNumberOfPlayersView.addActionListenerNrOfPlayersComboBox(
                event -> {
                    NrOfPlayersComboBox nrOfPlayersComboBox = (NrOfPlayersComboBox) event.getSource();
                    int nrOfPlayers = nrOfPlayersComboBox.getNrOfPlayersSelected();
                    setNrOfPlayerFieldsShown(nrOfPlayers);
                }
            );
    }

    private void addActionListenerStartGameButton() {
        selectNumberOfPlayersView.addActionListenerStartGameButton(
                event -> selectNumberOfPlayersListener.startGameButtonPressed()
        );
    }

    private void addActionListenerGoToMainMenuButton() {
        selectNumberOfPlayersView.addActionListenerGoToMainMenuButton(
                event -> selectNumberOfPlayersListener.goToMainMenuButtonPressed()
        );
    }

    private void setNrOfPlayerFieldsShown(int nrOfFields) {
        if (nrOfFields == 2) {
            showTwoPlayerFields();
        }
        else if (nrOfFields == 3) {
            showThreePlayerFields();
        }
        else if (nrOfFields == 4) {
            showFourPlayerFields();
        }
        else if (nrOfFields == 5) {
            showFivePlayerFields();
        }
        else if (nrOfFields == 6) {
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

    public int getNumberOfPlayers() {
        return selectNumberOfPlayersView.getNumberOfPlayers();
    }

    public String getPlayerName(int playerNr) {
        if (playerNr == 1) {
            return selectNumberOfPlayersView.getNamePlayer1();
        }
        else if (playerNr == 2) {
            return selectNumberOfPlayersView.getNamePlayer2();
        }
        else if (playerNr == 3) {
            return selectNumberOfPlayersView.getNamePlayer3();
        }
        else if (playerNr == 4) {
            return selectNumberOfPlayersView.getNamePlayer4();
        }
        else if (playerNr == 5) {
            return selectNumberOfPlayersView.getNamePlayer5();
        }
        else if (playerNr == 6) {
            return selectNumberOfPlayersView.getNamePlayer6();
        }
        throw new RuntimeException("SelectNumberOfPlayersController: Error in entering player Name");
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }

    public void setSelectNumberOfPlayersListener(SelectNumberOfPlayersListener selectNumberOfPlayersListener) {
        this.selectNumberOfPlayersListener = selectNumberOfPlayersListener;
    }
}
