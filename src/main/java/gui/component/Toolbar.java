package gui.component;

import gui.listeners.ToolbarListener;
import messages.Messages;
import util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar implements ActionListener {
    private JButton saveButton;
    private ToolbarListener toolbarListener;

    public Toolbar(ToolbarListener toolbarListener) {
        System.out.println();
        this.toolbarListener = toolbarListener;
        saveButton = new JButton("Save");
        saveButton.setToolTipText(Messages.getMessage("toolbar.saveButtonToolTipText"));
        saveButton.setIcon(Util.createIcon("Save16.gif"));
        saveButton.addActionListener(this);
        add(saveButton);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clicked = (JButton) event.getSource();

        if (toolbarListener == null) {
            return;
        }

        if (clicked == saveButton) {
            toolbarListener.saveButtonPressed();
        }
    }
}
