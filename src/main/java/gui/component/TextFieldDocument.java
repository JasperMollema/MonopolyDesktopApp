package gui.component;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldDocument extends PlainDocument {
    int maxLength;

    public TextFieldDocument(int maxLength) {
        this.maxLength = maxLength;
    }

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
        return textFieldLength <= maxLength;
    }
}
