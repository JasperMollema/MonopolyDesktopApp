package gui.component;

import settings.Settings;

import javax.swing.*;

public class PlayerNameTextField extends JTextField {

    public PlayerNameTextField(String defaultText) {
        super(defaultText);
        setDocument(new TextFieldDocument(Settings.MAX_LENGTH_PLAYER_NAME));
        setColumns(Settings.MAX_LENGTH_PLAYER_NAME);
    }
}
