package gui.view;

import java.awt.*;

public abstract class AbstractGridBagView extends AbstractView {
    protected GridBagConstraints gridBagConstraints;

    protected final int FIRST_ROW= 1;
    protected final int SECOND_ROW = 2;
    protected final int THIRD_ROW = 3;
    protected final int FOURTH_ROW = 4;
    protected final int FIFTH_ROW = 5;
    protected final int SIXTH_ROW = 6;
    protected final int SEVENTH_ROW = 7;
    protected final int EIGHT_ROW = 8;
    protected final int NINTH_ROW = 9;
    protected final int TENTH_ROW = 10;

    protected final int FIRST_COLUMN = 1;
    protected final int SECOND_COLUMN = 2;
    protected final int THIRD_COLUMN = 3;
    protected final int FOURTH_COLUMN = 4;
    protected final int FIFTH_COLUMN = 5;
    protected final int SIXTH_COLUMN = 6;
    protected final int SEVENTH_COLUMN = 7;
    protected final int EIGHT_COLUMN = 8;
    protected final int NINTH_COLUMN = 9;
    protected final int TENTH_COLUMN = 10;

    protected void addComponentToGridBagConstraints(Component component, int row, int column) {
        gridBagConstraints.gridx = column;
        gridBagConstraints.gridy = row;
        add(component, gridBagConstraints);
    }

    protected void initializeGridBagConstraints() {
        gridBagConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
    }
}
