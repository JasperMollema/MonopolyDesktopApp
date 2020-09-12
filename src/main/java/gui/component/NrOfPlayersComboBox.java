package gui.component;

import messages.Messages;

import javax.swing.*;

public class NrOfPlayersComboBox extends JComboBox {
    public NrOfPlayersComboBox() {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement(NrOfPlayers.TWO_PLAYERS);
        defaultComboBoxModel.addElement(NrOfPlayers.THREE_PLAYERS);
        defaultComboBoxModel.addElement(NrOfPlayers.FOUR_PLAYERS);
        defaultComboBoxModel.addElement(NrOfPlayers.FIVE_PLAYERS);
        defaultComboBoxModel.addElement(NrOfPlayers.SIX_PLAYERS);
        setModel(defaultComboBoxModel);
    }

    public int getNrOfPlayersSelected() {
        NrOfPlayers selectedItem = (NrOfPlayers) getSelectedItem();
        return selectedItem.nrOfPlayers;
    }

    private enum NrOfPlayers {
        TWO_PLAYERS(2),
        THREE_PLAYERS(3),
        FOUR_PLAYERS(4),
        FIVE_PLAYERS(5),
        SIX_PLAYERS(6);

        private Integer nrOfPlayers;
        private String stringValue;
        private Messages messages;

        NrOfPlayers(Integer nrOfPlayers) {
            this.nrOfPlayers = nrOfPlayers;
            messages = new Messages();
            stringValue = messages.getMessage("nrOfPlayers.nrOfPlayers", nrOfPlayers.toString());
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }
}
