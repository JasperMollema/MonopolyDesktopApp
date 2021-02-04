package gui.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainMenuBagView extends AbstractGridBagView {
    private final String NAME_VIEW = "MainMenuView";
    private JButton newGameButton;
    private JButton loadGameButton;

    @Override
    public void initializeView() {
        System.out.println(NAME_VIEW + " : initializeView()");
        newGameButton = new JButton(getMessage("startMenu.newGame"));
        loadGameButton = new JButton(getMessage("startMenu.loadGame"));
        layOutComponents();
    }

    private void layOutComponents() {
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(newGameButton, 1, 1);
        addComponentToGridBagConstraints(loadGameButton, 1, 2);
    }

    @Override
    public String getViewName() {
        return NAME_VIEW;
    }

    public void setActionListenerNewGameButton(ActionListener actionListener) {
        newGameButton.addActionListener(actionListener);
    }

    public void setActionListenerToLoadGameButton(ActionListener actionListener) {
        loadGameButton.addActionListener(actionListener);
    }
}
