package gui.component;

import javax.swing.*;
import java.awt.*;

public class ColorBoxCellRenderer extends JPanel implements ListCellRenderer {
    JLabel jLabel;
    JButton jButton;

    public ColorBoxCellRenderer() {
        setOpaque(true);
        jLabel = new JLabel();
        jButton = new JButton();
    }

    @Override
    public void setBackground(Color color) {
        if (color != null)
            super.setBackground(color);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof ComboBoxColor) {
            ComboBoxColor comboBoxColor = (ComboBoxColor) value;
            jLabel.setText((comboBoxColor.toString()));
            jButton.setBackground(comboBoxColor.getColor());
            setLayout(new GridLayout());
            add(jLabel);
            add(jButton);
        }
        return this;
    }
}
