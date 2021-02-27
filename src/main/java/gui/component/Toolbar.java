package gui.component;

import gui.listeners.ToolbarListener;
import messages.Messages;
import util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar implements ActionListener {
    private JButton saveButton;
    private JButton goToMainMenuButton;
    private ToolbarListener toolbarListener;

    public Toolbar(ToolbarListener toolbarListener) {
        System.out.println();
        this.toolbarListener = toolbarListener;

        saveButton = new JButton(Messages.getMessage("saveDialog.save"));
        saveButton.setToolTipText(Messages.getMessage("toolbar.saveButtonToolTipText"));
        saveButton.setIcon(Util.createIcon("Save16.gif"));
        saveButton.addActionListener(this);

        goToMainMenuButton = new JButton(Messages.getMessage("toolbar.goToMainMenuButton"));
        goToMainMenuButton.setToolTipText(Messages.getMessage("toolbar.goToMainMenuButtonToolTipText"));
        goToMainMenuButton.addActionListener(this);

        add(saveButton);
        add(goToMainMenuButton);
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

        if (clicked == goToMainMenuButton) {
            toolbarListener.goToMainMenuButtonPressed();
        }
    }
}
