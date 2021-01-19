package gui.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanelView extends AbstractView {
    private JLabel statusMessage;
    private JButton throwDiceButton;

    public ControlPanelView() {
        statusMessage = new JLabel();
        throwDiceButton = new JButton(getMessage("controlPanel.throwDice"));
        add(statusMessage);
        add(throwDiceButton);
        setVisible(true);
    }

    public void addActionListenerToThrowDiceButton(ActionListener actionListener) {
        throwDiceButton.addActionListener(actionListener);
    }

    @Override
    public String getViewName() {
        return "ControlPanelView";
    }

    @Override
    public void initializeView() {
    }

    public void fillStatusMessage(String messageResource, String[] args) {
        statusMessage.setText(getMessage(messageResource, args));
    }
}
