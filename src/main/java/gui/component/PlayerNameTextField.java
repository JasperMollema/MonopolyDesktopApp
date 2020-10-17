package gui.component;

import settings.Settings;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class PlayerNameTextField extends JTextField {
    private PlayerNameTextFieldDocument textFieldDocument;

    public PlayerNameTextField(String defaultText) {
        super(defaultText);
        textFieldDocument = new PlayerNameTextFieldDocument();
        setDocument(textFieldDocument);
        setColumns(Settings.MAX_LENGTH_PLAYER_NAME);
    }

    private class PlayerNameTextFieldDocument extends PlainDocument {
        @Override
        public void insertString(int offs, String string, AttributeSet a) throws BadLocationException {
            if (!validateTextInput(string)) {
                return;
            }
            super.insertString(offs, string, a);
        }

        private boolean validateTextInput(String string) {
            if (string == null) {
                return false;
            }
            int textFieldLength = string.length() + getLength();
            return textFieldLength <= Settings.MAX_LENGTH_PLAYER_NAME;
        }
    }
}
