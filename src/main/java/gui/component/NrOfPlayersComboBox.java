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

    public Integer getNrOfPlayersSelected() {
        NrOfPlayers selectedItem = (NrOfPlayers) getSelectedItem();
        return selectedItem.nrOfPlayers;
    }

    public void setNrOfPlayersSelected(Integer nrOfPlayersSelected) {
        switch (nrOfPlayersSelected) {
            case 3: setSelectedItem(NrOfPlayers.THREE_PLAYERS);
            break;
            case 4: setSelectedItem(NrOfPlayers.FOUR_PLAYERS);
            break;
            case 5: setSelectedItem(NrOfPlayers.FIVE_PLAYERS);
            break;
            case 6: setSelectedItem(NrOfPlayers.SIX_PLAYERS);
            break;
            default: setSelectedItem(NrOfPlayers.TWO_PLAYERS);
        }
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
