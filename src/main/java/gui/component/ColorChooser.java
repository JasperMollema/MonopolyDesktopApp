package gui.component;

import java.util.HashMap;
import java.util.Map;

public class ColorChooser {
    private static Map<Integer, ColorComboBox> colorComboBoxes;
    private static int nrOfComboBoxes = 0;

    public ColorChooser() {
        if (colorComboBoxes == null)
        colorComboBoxes = new HashMap<>();
    }

    public void addComboBox(ColorComboBox colorComboBox) {
        colorComboBoxes.put(nrOfComboBoxes++, colorComboBox);
    }

    public void selectColor(ColorComboBox colorComboBox) {
        if (colorComboBoxes.containsValue(colorComboBox)) {
            for (Integer integer : colorComboBoxes.keySet()) {

            }
        }

//        for (int i = 0; i < colorComboBoxes.size() && i != index; i++) {
//            colorComboBoxes.get(i).removeItem(colorComboBox.getSelectedItem());
//        }
    }
}
