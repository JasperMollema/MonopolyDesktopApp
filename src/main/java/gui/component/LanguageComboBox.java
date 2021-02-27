package gui.component;

import messages.Messages;

import javax.swing.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LanguageComboBox extends JComboBox {
    private Map<String, Locale> displayNameLocaleMap;
    private DefaultComboBoxModel<String> defaultComboBoxModel;

    public LanguageComboBox() {
        defaultComboBoxModel = new DefaultComboBoxModel<>();
        displayNameLocaleMap = new HashMap<>();

        fillComboBoxAndMap();
        setCurrentLocaleOnTop();
        setModel(defaultComboBoxModel);
    }

    private void fillComboBoxAndMap() {
        for (Locale locale : Messages.LOCALES) {
            String displayLanguage = locale.getDisplayLanguage(locale);
            displayNameLocaleMap.put(displayLanguage, locale);
            defaultComboBoxModel.addElement(displayLanguage);
        }
    }

    private void setCurrentLocaleOnTop() {
        Locale currentLocale = Messages.getLocale();
        String currentDisplayLanguage = currentLocale.getDisplayLanguage(currentLocale);
        defaultComboBoxModel.removeElement(currentDisplayLanguage);
        defaultComboBoxModel.insertElementAt(currentDisplayLanguage, 0);
        defaultComboBoxModel.setSelectedItem(currentDisplayLanguage);
    }

    public Locale getSelectedLocale() {
        String displayName = (String) defaultComboBoxModel.getSelectedItem();
        return displayNameLocaleMap.get(displayName);
    }
}
