package gui.controller;

import gui.component.NrOfPlayersComboBox;
import gui.listeners.PlayerSetupRowListenerImpl;
import gui.listeners.PlayersSetupListener;
import gui.view.PlayerSetupRowView;
import gui.view.PlayersSetupView;
import gui.view.ViewFactory;
import messages.Messages;
import settings.Settings;
import valueObjects.PlayerValueObject;

import javax.swing.*;
import java.util.List;

public class PlayersSetupController extends AbstractController {
    private final String NAME_CONTROLLER = "PlayersSetupController";

    private PlayersSetupView playersSetupView;
    private PlayersSetupListener playersSetupListener;
    private PlayersSetupRowControllerList playersSetupRowControllerList;

    public PlayersSetupController(PlayersSetupView playersSetupView) {
        this.playersSetupView = playersSetupView;
        playersSetupView.setNrOfPlayersSelectedInComboBox(Settings.DEFAULT_NR_OF_PLAYERS);
        PlayerSetupRowView[] playerSetupRowViews = createPlayersSetupRowViews();
        createPlayersSetupRowControllers(playerSetupRowViews);
        playersSetupView.setPlayerSetupRowViews(playerSetupRowViews);
    }

    private PlayerSetupRowView[] createPlayersSetupRowViews() {
        PlayerSetupRowView [] playerSetupRowViews = new PlayerSetupRowView[Settings.MAX_NR_PLAYERS];
        for (int i = 0; i < playerSetupRowViews.length; i++) {
            PlayerSetupRowView playerSetupRowView = (PlayerSetupRowView) ViewFactory.getView(ViewFactory.SETUP_PLAYERS_ROW);
            playerSetupRowViews[i] = playerSetupRowView;
        }
        return playerSetupRowViews;
    }

    private void createPlayersSetupRowControllers(PlayerSetupRowView[] playerSetupRowViews) {
        playersSetupRowControllerList = new PlayersSetupRowControllerList();
        for (int i= 0; i < playerSetupRowViews.length; i++) {
            PlayerSetupRowView playerSetupRowView = playerSetupRowViews[i];
            PlayersSetupRowController playersSetupRowController = (PlayersSetupRowController) ControllerFactory.getController(playerSetupRowView);
            playersSetupRowController.setPlayerSetupRowListener(new PlayerSetupRowListenerImpl(playersSetupRowController, this));
            playersSetupRowController.fillRowNr(i + 1);
            playersSetupRowControllerList.add(playersSetupRowController);
        }
    }

    @Override
    public void startController() {
        System.out.println(NAME_CONTROLLER + " : startView()");
        playersSetupRowControllerList.startPlayersSetupRowControllers();
        playersSetupView.initializeView();
        addActionListeners();
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
                    playersSetupView.setNrOfPlayersSelectedInComboBox(nrOfPlayers);
                    playersSetupRowControllerList.showRows(nrOfPlayers);
                }
            );
    }

    private void addActionListenerStartGameButton() {
        playersSetupView.addActionListenerStartGameButton(
                event -> playersSetupListener.startGameButtonPressed()
        );
    }

    private void addActionListenerGoToMainMenuButton() {
        playersSetupView.addActionListenerGoToMainMenuButton(
                event -> playersSetupListener.goToMainMenuButtonPressed()
        );
    }

    public List<PlayerValueObject> getPlayerValueObjects() {
        return playersSetupRowControllerList.getPlayerValueObjects();
    }

    @Override
    public String getControllerName() {
        return NAME_CONTROLLER;
    }

    public void setPlayersSetupListener(PlayersSetupListener playersSetupListener) {
        this.playersSetupListener = playersSetupListener;
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
