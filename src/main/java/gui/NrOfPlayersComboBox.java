package gui;

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
        return selectedItem.intValue;
    }

    private enum NrOfPlayers {
        TWO_PLAYERS(2, "2 players"), THREE_PLAYERS(3, "3 players"), FOUR_PLAYERS(4, "4 players"),
        FIVE_PLAYERS(5, "5 players"), SIX_PLAYERS(6, "6 players");

        private int intValue;
        private String stringValue;

        private NrOfPlayers(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;
        }


        @Override
        public String toString() {
            return stringValue;
        }
    }
}
