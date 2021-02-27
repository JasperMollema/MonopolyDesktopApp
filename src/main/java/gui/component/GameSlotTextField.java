package gui.component;

import settings.Settings;

import javax.swing.*;

public class GameSlotTextField extends JTextField {
    public GameSlotTextField() {
        setColumns(Settings.MAX_LENGTH_GAME_SLOT);
        setDocument(new TextFieldDocument(Settings.MAX_LENGTH_GAME_SLOT));
    }
}
