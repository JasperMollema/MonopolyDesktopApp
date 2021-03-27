package gui.view;

import gui.component.ColorComboBox;
import gui.component.PlayerNameTextField;
import messages.Messages;
import util.Util;

import javax.swing.*;

public class
PlayerSetupRowView extends AbstractView {
    private JLabel playerLabel;
    private PlayerNameTextField playerName;
    private JCheckBox isComputer;
    private ColorComboBox colorComboBox;

    public PlayerSetupRowView() {
        playerLabel = new JLabel(Messages.getMessage("selectNrOfPlayers.playerName", Util.stringValue(1)));
        playerName = new PlayerNameTextField(Messages.getMessage("selectNrOfPlayers.player", Util.stringValue(1)));
        isComputer = new JCheckBox();
        colorComboBox = new ColorComboBox();
    }

    @Override
    public String getViewName() {
        return getClass().getSimpleName();
    }

    @Override
    public void initializeView() {

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
}
