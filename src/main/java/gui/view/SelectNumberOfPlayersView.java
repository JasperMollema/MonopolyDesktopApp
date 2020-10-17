package gui.view;

import gui.component.NrOfPlayersComboBox;
import gui.component.PlayerNameTextField;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SelectNumberOfPlayersView extends AbstractGridBagView {
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
        player1Name = new PlayerNameTextField(getMessage("selectNrOfPlayers.player", "1"));
        player2Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "2"));
        player2Name = new PlayerNameTextField(getMessage("selectNrOfPlayers.player", "2"));
        player3Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "3"));
        player3Name = new PlayerNameTextField(getMessage("selectNrOfPlayers.player", "3"));
        player4Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "4"));
        player4Name = new PlayerNameTextField(getMessage("selectNrOfPlayers.player", "4"));
        player5Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "5"));
        player5Name = new PlayerNameTextField(getMessage("selectNrOfPlayers.player", "5"));
        player6Label = new JLabel(getMessage("selectNrOfPlayers.playerName", "6"));
        player6Name = new PlayerNameTextField(getMessage("selectNrOfPlayers.player", "6"));
        startGame = new JButton(getMessage("selectNrOfPlayers.startGame"));
        goToMainMenu = new JButton(getMessage("selectNrOfPlayers.goToMainMenu"));

        layoutComponents();
    }

    private void layoutComponents() {
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(nrOfPlayersComboBox, FIRST_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player1Label, SECOND_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player1Name, SECOND_ROW, SECOND_COLUMN);
        addComponentToGridBagConstraints(player2Label, THIRD_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player2Name, THIRD_ROW, SECOND_COLUMN);
        addComponentToGridBagConstraints(player3Label, FOURTH_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player3Name, FOURTH_ROW, SECOND_COLUMN);
        addComponentToGridBagConstraints(player4Label, FIFTH_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player4Name, FIFTH_ROW, SECOND_COLUMN);
        addComponentToGridBagConstraints(player5Label, SIXTH_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player5Name, SIXTH_ROW, SECOND_COLUMN);
        addComponentToGridBagConstraints(player6Label, SEVENTH_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(player6Name, SEVENTH_ROW, SECOND_COLUMN);
        addComponentToGridBagConstraints(startGame, EIGHT_ROW, FIRST_COLUMN);
        addComponentToGridBagConstraints(goToMainMenu, EIGHT_ROW, SECOND_COLUMN);
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

    public String getNamePlayer1() {
        return player1Name.getText();
    }

    public String getNamePlayer2() {
        return player2Name.getText();
    }

    public String getNamePlayer3() {
        return player3Name.getText();
    }

    public String getNamePlayer4() {
        return player4Name.getText();
    }

    public String getNamePlayer5() {
        return player5Name.getText();
    }

    public String getNamePlayer6() {
        return player6Name.getText();
    }

    public int getNumberOfPlayers() {
        return nrOfPlayersComboBox.getNrOfPlayersSelected();
    }

    @Override
    public String getViewName() {
        return "SelectNumberOfPlayersView";
    }
}
