package gui.view;

import gui.component.ColorComboBox;
import gui.component.ComboBoxColor;
import gui.component.PlayerNameTextField;
import messages.Messages;
import util.Util;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PlayerSetupRowView extends AbstractView {
    private JLabel playerLabel;
    private PlayerNameTextField playerName;
    private JCheckBox isComputer;
    private ColorComboBox colorComboBox;
    private int rowNr;

    @Override
    public void initializeView() {
        playerLabel = new JLabel(Messages.getMessage("selectNrOfPlayers.playerName", Util.stringValue(rowNr)));
        playerName = new PlayerNameTextField(Messages.getMessage("selectNrOfPlayers.player", Util.stringValue(rowNr)));
        isComputer = new JCheckBox();
        colorComboBox = new ColorComboBox();
    }

    public void setVisibilityComponents(boolean showComponent) {
        playerLabel.setVisible(showComponent);
        playerName.setVisible(showComponent);
        playerName.setText(showComponent ? playerName.getText() : "");
        isComputer.setVisible(showComponent);
        isComputer.setSelected(showComponent ? isComputer.isSelected() : false);
        colorComboBox.setVisible(showComponent);
        colorComboBox.setSelectedItem(showComponent ? colorComboBox.getSelectedItem() : ComboBoxColor.CHOOSE_COLOR);
    }

    public void addActionListenerToPlayerName(ActionListener actionListener) {
        playerName.addActionListener(actionListener);
    }

    public void addActionListenerToIsComputerCheckBox(ActionListener actionListener) {
        isComputer.addActionListener(actionListener);
    }

    public void addActionListenerToColorComboBox(ActionListener actionListener) {
        colorComboBox.addActionListener(actionListener);
    }

    @Override
    public String getViewName() {
        return getClass().getSimpleName();
    }

    public JLabel getPlayerLabel() {
        return playerLabel;
    }

    public PlayerNameTextField getPlayerNameTextField() {
        return playerName;
    }

    public String getPlayerName() {return playerName.getText();}

    public JCheckBox getIsComputerCheckBox() {
        return isComputer;
    }

    public Boolean getIsComputer() {
        return isComputer.isSelected();
    }

    public String getPlayerColor() {
        return colorComboBox.getColor();
    }

    public ColorComboBox getColorComboBox() {
        return colorComboBox;
    }

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }
}
