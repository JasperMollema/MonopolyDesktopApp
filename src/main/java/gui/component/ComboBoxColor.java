package gui.component;

import java.awt.*;

public enum ComboBoxColor {
    DARK_RED(new Color(139, 0, 0)),
    RED(new Color(250, 0, 0)),
    ORANGE(new Color(255, 165, 0)),
    YELLOW(new Color(255, 255, 0)),
    TURQUOISE(new Color(64, 224, 208)),
    GREEN(new Color(0, 128, 0)),
    LIME(new Color(0, 255, 0)),
    CYAN(new Color(0, 255, 255)),
    BLUE(new Color(0, 0, 255)),
    NAVY(new Color(0, 0, 128)),
    PURPLE(new Color(128, 0, 128)),
    PINK(new Color(255, 0, 255)),
    AQUA_MARINE(new Color(127, 255, 212)),
    LAVENDER(new Color(220, 208, 255)),
    SIENNA(new Color(160, 82, 45)),
    WHITE(new Color(250, 250, 250)),
    BLACK(new Color(0, 0, 0));

    private Color color;
    private boolean isSelected;
    private String colorName;

    private ComboBoxColor(Color color) {
        this.color = color;
        isSelected = false;
        fillColorName();
    }

    private void fillColorName() {
        StringBuilder stringBuilder = new StringBuilder();
        String unformattedColorName = name().toLowerCase();
        boolean shouldBeUpperCase = true;
        for (int i = 0; i < unformattedColorName.length(); i++) {
            String subString = unformattedColorName.substring(i, i + 1);
            if (shouldBeUpperCase) {
                subString = subString.toUpperCase();
                shouldBeUpperCase = false;
            }
            if (subString.equals("_")) {
                subString = " ";
                shouldBeUpperCase = true;
            }
            stringBuilder.append(subString);
        }
        colorName = stringBuilder.toString();
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return colorName;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
