package gui.controller;

import gui.component.NrOfPlayersComboBox;
import gui.listeners.PlayerSetupRowListenerImpl;
import gui.listeners.SelectNumberOfPlayersListener;
import gui.view.PlayerSetupRowView;
import gui.view.PlayersSetupView;
import gui.view.ViewFactory;
import messages.Messages;
import settings.Settings;

import javax.swing.*;
import java.util.List;

public class PlayersSetupController extends AbstractController {
    private final String NAME_CONTROLLER = "SelectNumberOfPlayersController";
    private final Integer DEFAULT_NR_OF_PLAYERS = 4;

    private PlayersSetupView playersSetupView;
    private SelectNumberOfPlayersListener selectNumberOfPlayersListener;

    public PlayersSetupController(PlayersSetupView playersSetupView) {
        this.playersSetupView = playersSetupView;
    }

    @Override
    public void startController() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        playersSetupView.setNrOfPlayersSelectedInComboBox(DEFAULT_NR_OF_PLAYERS);
        PlayerSetupRowView[] playerSetupRowViews = createPlayerSetupRows();
        playersSetupView.setPlayerSetupRowViews(playerSetupRowViews);
        playersSetupView.initializeView();
        addActionListeners();
    }

    private PlayerSetupRowView[] createPlayerSetupRows() {
        PlayerSetupRowView [] playerSetupRowViews = new PlayerSetupRowView[Settings.MAX_NR_PLAYERS];
        for (int i = 0; i < playerSetupRowViews.length; i++) {
            PlayerSetupRowView playerSetupRowView = (PlayerSetupRowView) ViewFactory.getView(ViewFactory.SETUP_PLAYERS_ROW);
            PlayersSetupRowController playersSetupRowController = (PlayersSetupRowController) ControllerFactory.getController(playerSetupRowView);
            playersSetupRowController.setPlayerSetupRowListener(new PlayerSetupRowListenerImpl(playersSetupRowController, this));
            playerSetupRowViews[i] = playerSetupRowView;
        }
        return playerSetupRowViews;
    }

    private void addActionListeners() {
        addActionListenerNrOfPlayerComboBox();
        addActionListenerStartGameButton();
        addActionListenerGoToMainMenuButton();
    }

    private void addActionListenerNrOfPlayerComboBox() {
        playersSetupView.addActionListenerNrOfPlayersComboBox(
                event -> {
                    NrOfPlayersComboBox nrOfPlayersComboBox = (NrOfPlayersComboBox) event.getSource();
                    int nrOfPlayers = nrOfPlayersComboBox.getNrOfPlayersSelected();
                    showPlayerRows(nrOfPlayers);
                }
            );
    }

    private void addActionListenerStartGameButton() {
        playersSetupView.addActionListenerStartGameButton(
                event -> selectNumberOfPlayersListener.startGameButtonPressed()
        );
    }

    private void addActionListenerGoToMainMenuButton() {
        playersSetupView.addActionListenerGoToMainMenuButton(
                event -> selectNumberOfPlayersListener.goToMainMenuButtonPressed()
        );
    }

    private void showPlayerRows(int nrOfFields) {
        playersSetupView.setNrOfPlayersSelectedInComboBox(nrOfFields);
        playersSetupView.showPlayerRows(nrOfFields);
    }


    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }

    public void setSelectNumberOfPlayersListener(SelectNumberOfPlayersListener selectNumberOfPlayersListener) {
        this.selectNumberOfPlayersListener = selectNumberOfPlayersListener;
    }

    public void showWarningMessagesEmptyName() {
        JOptionPane.showMessageDialog(
                null,
                Messages.getMessage("selectNrOfPlayers.messageEmptyPlayerName"),
                Messages.getMessage("selectNrOfPlayers.messageEmptyPlayerNameTitle"),
                JOptionPane.OK_OPTION);
    }

    public void showWarningMessageSamePlayerNames() {
        JOptionPane.showMessageDialog(
                null,
                Messages.getMessage("selectNrOfPlayers.messageIdenticalPlayerName"),
                Messages.getMessage("selectNrOfPlayers.messageIdenticalPlayerNameTitle"),
                JOptionPane.OK_OPTION);
    }

    public void clear() {

    }

    public List<PlayerSetupRowView> getPlayerSetupRowViews() {
        return null;
    }
}
