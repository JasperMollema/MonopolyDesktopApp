package gui.view;

import gui.component.LanguageComboBox;
import gui.component.MenuButton;
import messages.Messages;

import java.awt.event.ActionListener;
import java.util.Locale;

public class ChooseLanguageView extends AbstractGridBagView {
    private LanguageComboBox languageComboBox;
    private MenuButton menuButton;

    public ChooseLanguageView() {
        languageComboBox = new LanguageComboBox();
        menuButton = new MenuButton(Messages.getMessage("toolbar.goToMainMenuButton"));

        layOutComponents();
    }

    private void layOutComponents() {
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(languageComboBox, 0, 0);
        addComponentToGridBagConstraints(menuButton, 0, 1);
    }

    public void setActionListenerLanguageComboBox(ActionListener actionListener) {
        languageComboBox.addActionListener(actionListener);
    }

    public void setActionListenerMenuButton(ActionListener actionListener) {
        menuButton.addActionListener(actionListener);
    }

    @Override
    public String getViewName() {
        return "ChooseLanguageView";
    }

    @Override
    public void initializeView() {
    }

    public Locale getSelectedLanguage() {
        return languageComboBox.getSelectedLocale();
    }
}
