package gui.listeners;

import gui.controller.MainController;
import messages.Messages;

import java.util.Locale;

public class ChooseLanguageListenerImpl implements ChooseLanguageListener {
    private MainController mainController;
    private boolean languageChosen;

    public ChooseLanguageListenerImpl(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void languageChosen(Locale locale) {
        System.out.println("Locale selected : " + locale.getDisplayLanguage(locale));
        Messages.changeLocale(locale);
        mainController.refresh();
    }

    @Override
    public void menuButtonPressed() {
        mainController.showMenu();
    }
}
