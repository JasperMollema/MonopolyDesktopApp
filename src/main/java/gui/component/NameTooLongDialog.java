package gui.component;

import javax.swing.*;
import java.awt.*;

public class NameTooLongDialog extends JDialog {
    private JButton okButton;

    public NameTooLongDialog(Dialog owner, String title, boolean modal) {
        super(owner, title, modal);
        this.okButton = new JButton("OK");
    }
}
