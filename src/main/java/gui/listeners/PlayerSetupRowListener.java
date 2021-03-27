package gui.listeners;

import gui.component.ColorComboBox;
import gui.component.ComboBoxColor;

public interface PlayerSetupRowListener {
    void colorSelected(ComboBoxColor comboBoxColor, int rowNr);
    void selectFirstAvailableColor(ColorComboBox colorComboBox);
}
