package gui.component;

import gui.listeners.SaveDialogListener;
import messages.Messages;

import javax.swing.*;
import java.awt.*;

public class SaveDialog extends JDialog {
    private JButton saveButton;
    private JButton cancelButton;
    private SaveDialogListener saveDialogListener;

    public SaveDialog(Frame owner) {
        super(owner, "Save Game", true);
        setSize(300, 220);
        setLocationRelativeTo(owner);
        setLayout(new GridBagLayout());

        saveButton = new JButton(Messages.getMessage("saveDialog.save"));
        cancelButton = new JButton(Messages.getMessage("saveDialog.cancel"));

        add(saveButton);
        saveButton.addActionListener(event -> {
           if (saveDialogListener != null) {
               saveDialogListener.saveButtonPressed();
           }
        });

        add(cancelButton);
        cancelButton.addActionListener(event -> {
            if (saveDialogListener != null) {
                saveDialogListener.cancelButtonPressed();
            }
        });
    }

    public void setSaveDialogListener(SaveDialogListener saveDialogListener) {
        this.saveDialogListener = saveDialogListener;
    }
}
