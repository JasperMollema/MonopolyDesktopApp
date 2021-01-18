package gui.view;

import javax.swing.*;

public class ControlPanelView extends AbstractView {
    private JLabel infoMessage;
    private JButton throwDiceButton;

    public ControlPanelView() {
        infoMessage = new JLabel();
        infoMessage.setText(getMessage("controlPanel.playerCanThrowDice", "[Name of player]"));
        throwDiceButton = new JButton(getMessage("controlPanel.throwDice"));
        add(infoMessage);
        add(throwDiceButton);
        setVisible(true);
    }

    @Override
    public String getViewName() {
        return "ControlPanelView";
    }

    @Override
    public void initializeView() {
    }
}
