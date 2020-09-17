package gui.view;

import gui.component.NrOfPlayersComboBox;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SelectNumberOfPlayersView extends AbstractMenuView {
    private NrOfPlayersComboBox nrOfPlayersComboBox;
    private JLabel player1Label;
    private JTextField player1Name;
    private JLabel player2Label;
    private JTextField player2Name;
    private JLabel player3Label;
    private JTextField player3Name;
    private JLabel player4Label;
    private JTextField player4Name;
    private JLabel player5Label;
    private JTextField player5Name;
    private JLabel player6Label;
    private JTextField player6Name;
    private JButton startGame;
    private JButton goToMainMenu;

    @Override
    public void initializeView() {
        System.out.println("Initialize SelectNumberOfPlayers View");
        nrOfPlayersComboBox = new NrOfPlayersComboBox();
        player1Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "1"));
        player1Name = new JTextField(getMessage("selectNrOfPlayers.player", "1"), COLUMN_SIZE);
        player2Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "2"));
        player2Name = new JTextField(getMessage("selectNrOfPlayers.player", "2"), COLUMN_SIZE);
        player3Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "3"));
        player3Name = new JTextField(getMessage("selectNrOfPlayers.player", "3"), COLUMN_SIZE);
        player4Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "4"));
        player4Name = new JTextField(getMessage("selectNrOfPlayers.player", "4"), COLUMN_SIZE);
        player5Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "5"));
        player5Name = new JTextField(getMessage("selectNrOfPlayers.player", "5"), COLUMN_SIZE);
        player6Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "6"));
        player6Name = new JTextField(getMessage("selectNrOfPlayers.player", "6"), COLUMN_SIZE);
        startGame = new JButton(getMessage("selectNrOfPlayers.startGame"));
        goToMainMenu = new JButton(getMessage("selectNrOfPlayers.goToMainMenu"));

        layoutComponents();
    }

    private void layoutComponents() {
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(nrOfPlayersComboBox, 1, 1);
        addComponentToGridBagConstraints(player1Label, 1, 2);
        addComponentToGridBagConstraints(player1Name, 2, 2);
        addComponentToGridBagConstraints(player2Label, 1, 3);
        addComponentToGridBagConstraints(player2Name, 2, 3);
        addComponentToGridBagConstraints(player3Label, 1, 4);
        addComponentToGridBagConstraints(player3Name, 2, 4);
        addComponentToGridBagConstraints(player4Label, 1, 5);
        addComponentToGridBagConstraints(player4Name, 2, 5);
        addComponentToGridBagConstraints(player5Label, 1, 6);
        addComponentToGridBagConstraints(player5Name, 2, 6);
        addComponentToGridBagConstraints(player6Label, 1, 7);
        addComponentToGridBagConstraints(player6Name, 2, 7);
        addComponentToGridBagConstraints(startGame, 1, 8);
        addComponentToGridBagConstraints(goToMainMenu, 2, 8);
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

    public void setVisibilityPlayer1Fields(boolean isVisible) {
        player1Name.setVisible(isVisible);
        player1Label.setVisible(isVisible);
    }

    public void setVisibilityPlayer2Fields(boolean isVisible) {
        player2Name.setVisible(isVisible);
        player2Label.setVisible(isVisible);
    }

    public void setVisibilityPlayer3Fields(boolean isVisible) {
        player3Name.setVisible(isVisible);
        player3Label.setVisible(isVisible);
    }

    public void setVisibilityPlayer4Fields(boolean isVisible) {
        player4Name.setVisible(isVisible);
        player4Label.setVisible(isVisible);
    }

    public void setVisibilityPlayer5Fields(boolean isVisible) {
        player5Name.setVisible(isVisible);
        player5Label.setVisible(isVisible);
    }

    public void setVisibilityPlayer6Fields(boolean isVisible) {
        player6Name.setVisible(isVisible);
        player6Label.setVisible(isVisible);
    }

    public void setNrOfPlayersSelected(Integer nrOfPlayersSelected) {
        nrOfPlayersComboBox.setNrOfPlayersSelected(nrOfPlayersSelected);
    }

    @Override
    public String getViewName() {
        return "SelectNumberOfPlayersView";
    }
}
