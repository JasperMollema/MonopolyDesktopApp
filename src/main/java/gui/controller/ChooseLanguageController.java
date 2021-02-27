package gui.controller;

import gui.listeners.ChooseLanguageListener;
import gui.view.ChooseLanguageView;

import java.util.Locale;

public class ChooseLanguageController extends AbstractController {
    private ChooseLanguageView chooseLanguageView;
    private ChooseLanguageListener chooseLanguageListener;

    public ChooseLanguageController(ChooseLanguageView chooseLanguageView) {
        this.chooseLanguageView = chooseLanguageView;
    }

    @Override
    public String getControllerName() {
        return "ChooseLanguageController";
    }

    @Override
    public void startController() {
        chooseLanguageView.initializeView();
        addActionListenerToLanguageBox();
        addActionListenerToMenuButton();
    }

    private void addActionListenerToLanguageBox() {
        chooseLanguageView.setActionListenerLanguageComboBox(event -> {
            if (chooseLanguageListener != null) {
                Locale chosenLocale = chooseLanguageView.getSelectedLanguage();
                chooseLanguageListener.languageChosen(chosenLocale);
            }
        });
    }

    private void addActionListenerToMenuButton() {
        chooseLanguageView.setActionListenerMenuButton(event -> {
            if (chooseLanguageView != null) {
                chooseLanguageListener.menuButtonPressed();
            }
        });
    }

    public void setChooseLanguageListener(ChooseLanguageListener chooseLanguageListener) {
        this.chooseLanguageListener = chooseLanguageListener;
    }
}
