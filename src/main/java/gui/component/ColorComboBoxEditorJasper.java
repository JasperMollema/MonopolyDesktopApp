package gui.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ColorComboBoxEditorJasper implements ComboBoxEditor {
    private JButton editor;

    public ColorComboBoxEditorJasper(ComboBoxColor comboBoxColor) {
        editor = new JButton("");
        editor.setBackground(comboBoxColor.getColor());
    }

    @Override
    public Component getEditorComponent() {
        return editor;
    }

    @Override
    public void setItem(Object newValue) {
        if (newValue instanceof ComboBoxColor) {
            ComboBoxColor comboBoxColor = (ComboBoxColor) newValue;
            editor.setBackground(comboBoxColor.getColor());

        }
    }

    @Override
    public Object getItem() {
        return editor.getBackground();
    }

    @Override
    public void selectAll() {

    }

    @Override
    public void addActionListener(ActionListener l) {


    }

    @Override
    public void removeActionListener(ActionListener l) {

    }
}
