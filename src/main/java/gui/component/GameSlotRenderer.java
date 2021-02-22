package gui.component;

import javax.swing.*;
import java.awt.*;

public class GameSlotRenderer implements ListCellRenderer<GameSlot> {
    private JPanel gameSlotPanel;
    private JLabel gameName;
    private JLabel timeStampGame;

    public GameSlotRenderer() {
        gameSlotPanel = new JPanel();
        gameName = new JLabel();
        timeStampGame = new JLabel();

        gameSlotPanel.setLayout(new BorderLayout());
        gameSlotPanel.add(gameName, BorderLayout.WEST);
        gameSlotPanel.add(timeStampGame, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends GameSlot> list, GameSlot value, int index, boolean isSelected, boolean cellHasFocus) {
        gameName.setText(value.getName());
        timeStampGame.setText(value.getTime());

        gameSlotPanel.setBackground(isSelected ? Color.DARK_GRAY : Color.BLACK);
        setTextColor(value.isEmptySlot()? Color.LIGHT_GRAY : Color.WHITE);

        return gameSlotPanel;
    }

    private void setTextColor(Color color) {
        gameName.setForeground(color);
        timeStampGame.setForeground(color);
    }
}
