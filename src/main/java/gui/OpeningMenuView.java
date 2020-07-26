package gui;

import gui.listeners.OpeningMenuListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OpeningMenuView extends JPanel {
    private JPanel upperPanel = new JPanel();
    private JPanel lowerPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private final int COLUMN_SIZE = 10;
    private JButton startGameBtn;
    private JComboBox nrOfPlayersComboBox;
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

    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private OpeningMenuListener menuListener;

    public OpeningMenuView() {
//        setLayout(new BorderLayout());
//        add(upperPanel, BorderLayout.NORTH);
//        add(lowerPanel, BorderLayout.SOUTH);
//        add(leftPanel, BorderLayout.WEST);
//        add(rightPanel, BorderLayout.EAST);

        startGameBtn = new JButton("New Game");
        nrOfPlayersComboBox = new JComboBox<String>();
        player1Label = new JLabel("Name player 1: ");
        player1Name = new JTextField("player 1", COLUMN_SIZE);
        player2Label = new JLabel("Name player 2: ");
        player2Name = new JTextField("player 2", COLUMN_SIZE);
        player3Label = new JLabel("Name player 3: ");
        player3Name = new JTextField("player 3", COLUMN_SIZE);
        player4Label = new JLabel("Name player 4: ");
        player4Name = new JTextField("player 4", COLUMN_SIZE);
        player5Label = new JLabel("Name player 5: ");
        player5Name = new JTextField("player 5", COLUMN_SIZE);
        player6Label = new JLabel("Name player 6: ");
        player6Name = new JTextField("player 6", COLUMN_SIZE);

        DefaultComboBoxModel nrOfPlayersModel = new DefaultComboBoxModel();
        nrOfPlayersModel.addElement("2 players");
        nrOfPlayersModel.addElement("3 players");
        nrOfPlayersModel.addElement("4 players");
        nrOfPlayersModel.addElement("5 players");
        nrOfPlayersModel.addElement("6 players");
        nrOfPlayersComboBox.setModel(nrOfPlayersModel);
        add(startGameBtn);

//        upperPanel.add(startGameBtn);
//
//        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
//        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
//
//        upperPanel.add(nrOfPlayersComboBox);
//        leftPanel.add(player1Label, RIGHT_ALIGNMENT);
//        rightPanel.add(player1Name, LEFT_ALIGNMENT);
//        leftPanel.add(player2Label, RIGHT_ALIGNMENT);
//        rightPanel.add(player2Name, LEFT_ALIGNMENT);
//        leftPanel.add(player3Label, RIGHT_ALIGNMENT);
//        rightPanel.add(player3Name, LEFT_ALIGNMENT);
//        leftPanel.add(player4Label, RIGHT_ALIGNMENT);
//        rightPanel.add(player4Name, LEFT_ALIGNMENT);
//        leftPanel.add(player5Label, RIGHT_ALIGNMENT);
//        rightPanel.add(player5Name, LEFT_ALIGNMENT);
//        leftPanel.add(player6Label, RIGHT_ALIGNMENT);
//        rightPanel.add(player6Name, LEFT_ALIGNMENT);
        layoutComponents();
        setVisibilityNrOfPlayersComboBox(false);
        setVisibilityPlayer1Fields(false);
        setVisibilityPlayer2Fields(false);
        setVisibilityPlayer3Fields(false);
        setVisibilityPlayer4Fields(false);
        setVisibilityPlayer5Fields(false);
        setVisibilityPlayer6Fields(false);
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        addComponentGridBagConstraints(nrOfPlayersComboBox, 1, 1);
        addComponentGridBagConstraints(player1Label, 1, 2);
        addComponentGridBagConstraints(player1Name, 2, 2);
        addComponentGridBagConstraints(player2Label, 1, 3);
        addComponentGridBagConstraints(player2Name, 2, 3);
        addComponentGridBagConstraints(player3Label, 1, 4);
        addComponentGridBagConstraints(player3Name, 2, 4);
        addComponentGridBagConstraints(player4Label, 1, 5);
        addComponentGridBagConstraints(player4Name, 2, 5);
        addComponentGridBagConstraints(player5Label, 1, 6);
        addComponentGridBagConstraints(player5Name, 2, 6);
        addComponentGridBagConstraints(player6Label, 1, 7);
        addComponentGridBagConstraints(player6Name, 2, 7);

    }

    private void addComponentGridBagConstraints(Component component, int x, int y) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        add(component, gridBagConstraints);
    }

    public void addActionListenerStartGameBtn(ActionListener actionListener) {
        startGameBtn.addActionListener(actionListener);
    }

    public void setVisibilityStartGameBtn(boolean isVisible) {
        startGameBtn.setVisible(isVisible);
    }

    public void addActionListenerNrOfPlayersComboBox(ActionListener actionListener) {
        nrOfPlayersComboBox.addActionListener(actionListener);
    }

    public void setVisibilityNrOfPlayersComboBox(boolean isVisible) {
        nrOfPlayersComboBox.setVisible(isVisible);
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

    public void setNrOfPlayersSelected(String nrOfPlayersSelected) {
        nrOfPlayersComboBox.setSelectedItem(nrOfPlayersSelected);
    }
}
