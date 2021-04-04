package gui.view;

import gui.component.NrOfPlayersComboBox;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PlayersSetupView extends AbstractGridBagView {
    private NrOfPlayersComboBox nrOfPlayersComboBox;
    private PlayerSetupRowView[] playerSetupRowViews;
    private boolean isInitialized;
    private JButton startGame;
    private JButton goToMainMenu;

    public PlayersSetupView() {
        nrOfPlayersComboBox = new NrOfPlayersComboBox();
        startGame = new JButton(getMessage("selectNrOfPlayers.startGame"));
        goToMainMenu = new JButton(getMessage("selectNrOfPlayers.goToMainMenu"));
        isInitialized = true;
    }

    @Override
    public void initializeView() {
        System.out.println("Initialize SelectNumberOfPlayers View");

        if (isInitialized)
        layoutComponents();
    }

    private void layoutComponents() {
        initializeGridBagConstraints();
        int xCoordinateFirstColumn = 1;
        int xCoordinateSecondColumn = 2;
        int yCoordinate = 1;
        addComponentToGridBagConstraints(nrOfPlayersComboBox, xCoordinateFirstColumn, yCoordinate++);

        for (PlayerSetupRowView playerSetupRowView : playerSetupRowViews) {
            addRowToGridBagConstraint(playerSetupRowView, yCoordinate++);
        }
        addComponentToGridBagConstraints(startGame, xCoordinateFirstColumn, yCoordinate);
        addComponentToGridBagConstraints(goToMainMenu, xCoordinateSecondColumn, yCoordinate);
    }

    private void addRowToGridBagConstraint(PlayerSetupRowView playerSetupRowView, int yCoordinate) {
        int xCoordinate = 1;
        addComponentToGridBagConstraints(playerSetupRowView.getPlayerLabel(), xCoordinate++, yCoordinate);
        addComponentToGridBagConstraints(playerSetupRowView.getPlayerNameTextField(), xCoordinate++, yCoordinate);
        addComponentToGridBagConstraints(playerSetupRowView.getIsComputerCheckBox(), xCoordinate++, yCoordinate);
        addComponentToGridBagConstraints(playerSetupRowView.getColorComboBox(), xCoordinate++, yCoordinate);
    }

    public void addActionListenerNrOfPlayersComboBox(ActionListener actionListener) {
        nrOfPlayersComboBox.addActionListener(actionListener);
    }

    public void addActionListenerStartGameButton(ActionListener actionListener) {
        startGame.addActionListener(actionListener);
    }

    public void addActionListenerGoToMainMenuButton(ActionListener actionListener) {
        goToMainMenu.addActionListener(actionListener);
    }

    public void setNrOfPlayersSelectedInComboBox(Integer nrOfPlayersSelected) {
        nrOfPlayersComboBox.setNrOfPlayersSelected(nrOfPlayersSelected);
    }

    public void showPlayerRows (int nrOfRowsToBeShown) {
        for (int i =0; i < playerSetupRowViews.length; i++) {
            boolean isRowVisible = i < nrOfRowsToBeShown;
            playerSetupRowViews[i].setVisible(isRowVisible);
        }
    }

    @Override
    public String getViewName() {
        return "SelectNumberOfPlayersView";
    }

    public NrOfPlayersComboBox getNrOfPlayersComboBox() {
        return nrOfPlayersComboBox;
    }

    public void setNrOfPlayersComboBox(NrOfPlayersComboBox nrOfPlayersComboBox) {
        this.nrOfPlayersComboBox = nrOfPlayersComboBox;
    }

    public PlayerSetupRowView[] getPlayerSetupRowViews() {
        return playerSetupRowViews;
    }

    public void setPlayerSetupRowViews(PlayerSetupRowView[] playerSetupRowViews) {
        this.playerSetupRowViews = playerSetupRowViews;
    }
}
