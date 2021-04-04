package gui.component;

import javax.swing.*;

public class ColorComboBox extends JComboBox {

    public ColorComboBox() {
        setModel(new DefaultComboBoxModel(ComboBoxColor.values()));
        setRenderer(new ColorBoxCellRenderer());
    }

    public void hideColor(ComboBoxColor comboBoxColor) {
        removeItem(comboBoxColor);
    }

    public void showColor(ComboBoxColor comboBoxColor) {
        removeItem(comboBoxColor);
        addItem(comboBoxColor);
    }

    public String getColor() {
        ComboBoxColor comboBoxColor = (ComboBoxColor) getSelectedItem();
        return comboBoxColor.toString();
    }
}
