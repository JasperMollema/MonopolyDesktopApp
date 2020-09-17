package gui.view;

import java.awt.*;

public abstract class AbstractMenuView extends AbstractView {
    protected GridBagConstraints gridBagConstraints;

    protected void addComponentToGridBagConstraints(Component component, int x, int y) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        add(component, gridBagConstraints);
    }

    protected void initializeGridBagConstraints() {
        gridBagConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
    }
}
