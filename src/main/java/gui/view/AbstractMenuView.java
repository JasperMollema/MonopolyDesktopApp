package gui.view;

import java.awt.*;

public abstract class AbstractMenuView extends AbstractView {
    protected GridBagConstraints gridBagConstraints;

    protected void addComponentToGridBagConstraints(Component component, int x, int y) {
        initializeGridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        add(component, gridBagConstraints);
    }

    private void initializeGridBagConstraints() {
        gridBagConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
    }
}
