package gui.controller;

import gui.listeners.PlayerSetupRowListener;
import gui.view.PlayerSetupRowView;
import valueObjects.PlayerValueObject;

public class PlayersSetupRowController extends AbstractController {
    private PlayerSetupRowView playerSetupRowView;
    private PlayerSetupRowListener playerSetupRowListener;

    public PlayersSetupRowController(PlayerSetupRowView playerSetupRowView) {
        this.playerSetupRowView = playerSetupRowView;
    }

    @Override
    public String getControllerName() {
        return getClass().getSimpleName();
    }

    @Override
    public void startController() {
        playerSetupRowView.initializeView();
        addActionListeners();
    }

    private void addActionListeners() {
        addActionListenerToPlayerNameTextField();
        addActionListenerToIsComputerCheckBox();
        addActionListenerToColorComboBox();
    }

    private void addActionListenerToPlayerNameTextField() {
        playerSetupRowView.addActionListenerToPlayerName(
                event -> {

                }
        );
    }

    private void addActionListenerToIsComputerCheckBox() {
        playerSetupRowView.addActionListenerToIsComputerCheckBox(
                event -> {

                }
        );
    }

    private void addActionListenerToColorComboBox() {

    }

    public PlayerValueObject getPlayerValueObject() {
        PlayerValueObject playerValueObject = new PlayerValueObject();
        playerValueObject.name = playerSetupRowView.getPlayerName();
        playerValueObject.playerColor = playerSetupRowView.getPlayerColor();
        playerValueObject.isComputer = playerSetupRowView.getIsComputer();
        return playerValueObject;
    }

    public void setVisibilityRow(boolean showRow) {
        playerSetupRowView.setVisibilityComponents(showRow);
    }

    public void fillRowNr(int rowNr) {
        playerSetupRowView.setRowNr(rowNr);
    }

    public void setPlayerSetupRowListener(PlayerSetupRowListener playerSetupRowListener) {
        this.playerSetupRowListener = playerSetupRowListener;
    }
}
