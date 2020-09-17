package gui.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainMenuView extends AbstractMenuView {
    private final String NAME_VIEW = "MainMenuView";
    private JButton newGameButton;

    @Override
    public void initializeView() {
        System.out.println(NAME_VIEW + " : initializeView()");
        newGameButton = new JButton(getMessage("startMenu.newGame"));
        layOutComponents();
    }

    private void layOutComponents() {
        addComponentToGridBagConstraints(newGameButton, 1, 1);
    }

    @Override
    public String getViewName() {
        return NAME_VIEW;
    }

    public void setActionListenerNewGameButton(ActionListener actionListener) {
        newGameButton.addActionListener(actionListener);
    }
}
