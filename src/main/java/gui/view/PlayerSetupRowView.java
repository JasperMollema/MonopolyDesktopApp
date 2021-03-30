package gui.view;

import gui.component.ColorComboBox;
import gui.component.PlayerNameTextField;
import messages.Messages;
import util.Util;

import javax.swing.*;

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
    }

    @Override
    public String getViewName() {
        return getClass().getSimpleName();
    }

    public JLabel getPlayerLabel() {
        return playerLabel;
    }

    public PlayerNameTextField getPlayerName() {
        return playerName;
    }

    public JCheckBox getIsComputer() {
        return isComputer;
    }

    public ColorComboBox getColorComboBox() {
        return colorComboBox;
    }

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }
}
