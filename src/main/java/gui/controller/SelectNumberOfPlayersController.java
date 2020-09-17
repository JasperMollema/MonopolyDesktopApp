package gui.controller;

import gui.component.NrOfPlayersComboBox;
import gui.view.SelectNumberOfPlayersView;

public class SelectNumberOfPlayersController extends AbstractController {
    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private final String NAME_CONTROLLER = "SelectNumberOfPlayersController";

    public SelectNumberOfPlayersController(SelectNumberOfPlayersView selectNumberOfPlayersView) {
        this.selectNumberOfPlayersView = selectNumberOfPlayersView;
    }

    @Override
    public void startView() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        addActionListeners();
        setNrOfPlayerFieldsShown(4);
        selectNumberOfPlayersView.setVisibilityNrOfPlayersComboBox(true);
    }

    private void addActionListeners() {
        addActionListenerNrOfPlayerComboBox();
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

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }
}
