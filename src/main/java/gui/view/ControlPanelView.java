package gui.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanelView extends AbstractView {
    private JLabel infoMessage1;
    private JLabel infoMessage2;
    private JButton startTurnButton;
    private JButton endTurnButton;
    private JButton throwDiceButton;

    public ControlPanelView() {
        infoMessage1 = new JLabel();
        infoMessage2 = new JLabel();
        startTurnButton = new JButton(getMessage("controlPanel.startTurn"));
        endTurnButton = new JButton(getMessage("controlPanel.endTurn"));
        throwDiceButton = new JButton(getMessage("controlPanel.throwDice"));
        add(startTurnButton);
        startTurnButton.setEnabled(true);
        endTurnButton.setEnabled(false);
        throwDiceButton.setEnabled(false);
        add(endTurnButton);
        add(infoMessage1);
        hideInfoMessage1();
        add(infoMessage2);
        hideInfoMessage2();
        add(throwDiceButton);
        setVisible(true);
    }

    public void addActionListenerToStartTurnButton(ActionListener actionListener) {
        startTurnButton.addActionListener(actionListener);
    }

    public void addActionListenerToEndTurnButton(ActionListener actionListener) {
        endTurnButton.addActionListener(actionListener);
    }

    public void addActionListenerToThrowDiceButton(ActionListener actionListener) {
        throwDiceButton.addActionListener(actionListener);
    }

    public void enableStartTurnButton() {
        startTurnButton.setEnabled(true);
    }

    public void disableStartTurnButton() {
        startTurnButton.setEnabled(false);
    }

    public void enableEndTurnButton() {
        endTurnButton.setEnabled(true);
    }

    public void disableEndTurnButton() {
        endTurnButton.setEnabled(false);
    }

    public void enableThrowDiceTurnButton() {
        throwDiceButton.setEnabled(true);
    }

    public void disableThrowDiceTurnButton() {
        throwDiceButton.setEnabled(false);
    }

    @Override
    public String getViewName() {
        return "ControlPanelView";
    }

    @Override
    public void initializeView() {
    }

    public void showInfoMessage1() {
        infoMessage1.setVisible(true);
    }

    public void hideInfoMessage1() {
        infoMessage1.setVisible(false);
    }

    public void showInfoMessage2() {
        infoMessage2.setVisible(true);
    }

    public void hideInfoMessage2() {
        infoMessage2.setVisible(false);
    }

    public void fillInfoMessage1(String messageResource, String[] args) {
        infoMessage1.setText(getMessage(messageResource, args));
    }

    public void fillInfoMessage2(String messageResource, String[] args) {
        infoMessage2.setText(getMessage(messageResource, args));
    }
}
