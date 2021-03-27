package gui.listeners;

import gui.component.ColorComboBox;
import gui.component.ComboBoxColor;
import gui.controller.PlayersSetupController;
import gui.controller.PlayersSetupRowController;
import gui.view.PlayerSetupRowView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerSetupRowListenerImpl implements PlayerSetupRowListener {
    private PlayersSetupRowController playersSetupRowController;
    private PlayersSetupController playersSetupController;

    public PlayerSetupRowListenerImpl(PlayersSetupRowController playersSetupRowController, PlayersSetupController playersSetupController) {
        this.playersSetupRowController = playersSetupRowController;
        this.playersSetupController = playersSetupController;
    }

    @Override
    public void colorSelected(ComboBoxColor comboBoxColor, int rowNr) {
        List<PlayerSetupRowView> playerSetupRowViews = playersSetupController.getPlayerSetupRowViews();
        for (PlayerSetupRowView playerSetupRowView : playerSetupRowViews) {
            if (true){//playerSetupRowView.getRowNr() != rowNr) {
                playerSetupRowView.getColorComboBox().hideColor(comboBoxColor);
                comboBoxColor.setSelected(true);
            }
        }
        showUnselectedColors();
    }

    @Override
    public void selectFirstAvailableColor(ColorComboBox colorComboBox) {
        ComboBoxColor[] comboBoxColors = ComboBoxColor.values();
        for (int i = 0; i < comboBoxColors.length; i++) {
            colorComboBox.setSelectedItem(comboBoxColors[i]);
         }
    }

    private void showUnselectedColors() {
        List<ComboBoxColor> comboBoxColors = Arrays.asList(ComboBoxColor.values());
        List<ComboBoxColor> selectedColors = new ArrayList<>();
        List<ComboBoxColor> unSelectedColors = new ArrayList<>();
        List<PlayerSetupRowView> playerSetupRowViews = playersSetupController.getPlayerSetupRowViews();
        for (PlayerSetupRowView playerSetupRowView : playerSetupRowViews) {
            ColorComboBox colorComboBox = playerSetupRowView.getColorComboBox();
            ComboBoxColor selectedColor = (ComboBoxColor) colorComboBox.getSelectedItem();
            selectedColors.add(selectedColor);
        }

        for (ComboBoxColor comboBoxColor : comboBoxColors) {
            if (!selectedColors.contains(comboBoxColor)) {
                unSelectedColors.add(comboBoxColor);
            }
        }

        for (ComboBoxColor comboBoxColor : unSelectedColors) {
            for (PlayerSetupRowView playerSetupRowView : playerSetupRowViews) {
                ColorComboBox colorComboBox = playerSetupRowView.getColorComboBox();
                colorComboBox.showColor(comboBoxColor);
            }
        }
    }
}
