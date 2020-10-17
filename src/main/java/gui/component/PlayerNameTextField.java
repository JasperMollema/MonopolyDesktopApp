package gui.component;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class PlayerNameTextField extends JTextField {
    private final int MAX_LENGTH_PLAYER_NAME = 10;
    private PlayerNameTextFieldDocument textFieldDocument;

    public PlayerNameTextField(String defaultText) {
        super(defaultText);
        textFieldDocument = new PlayerNameTextFieldDocument();
        setDocument(textFieldDocument);
        setColumns(MAX_LENGTH_PLAYER_NAME);
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
            return textFieldLength <= MAX_LENGTH_PLAYER_NAME;
        }
    }
}
