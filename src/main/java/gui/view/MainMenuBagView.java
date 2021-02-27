package gui.view;

import gui.component.MenuButton;

import java.awt.event.ActionListener;

public class MainMenuBagView extends AbstractGridBagView {
    private final String NAME_VIEW = "MainMenuView";
    private MenuButton newGameButton;
    private MenuButton loadGameButton;
    private MenuButton languageButton;

    @Override
    public void initializeView() {
        System.out.println(NAME_VIEW + " : initializeView()");
        newGameButton = new MenuButton(getMessage("startMenu.newGame"));
        loadGameButton = new MenuButton(getMessage("startMenu.loadGame"));
        languageButton = new MenuButton(getMessage("startMenu.language"));
        layOutComponents();
    }

    private void layOutComponents() {
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(newGameButton, 1, 1);
        addComponentToGridBagConstraints(loadGameButton, 1, 2);
        addComponentToGridBagConstraints(languageButton, 1, 3);
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

    public void setActionListenerToLanguageButton(ActionListener actionListener) {
        languageButton.addActionListener(actionListener);
    }
}
