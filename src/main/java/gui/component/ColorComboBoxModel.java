package gui.component;

import javax.swing.*;
import java.util.List;

public class ColorComboBoxModel extends DefaultComboBoxModel {
    private static List<ComboBoxColor> comboBoxColors;
    private static List<ComboBoxColor> selectedColors;

    public ColorComboBoxModel(List<ComboBoxColor> colors) {
        if (comboBoxColors == null) {
            comboBoxColors = colors;
        }
    }

    public void colorSelected(ComboBoxColor comboBoxColor) {
        comboBoxColors.remove(comboBoxColor);
        selectedColors.add(comboBoxColor);
    }
}
