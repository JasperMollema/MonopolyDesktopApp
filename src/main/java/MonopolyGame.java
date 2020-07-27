import gui.MainFrame;
import gui.controller.ControllerFactory;
import gui.controller.SelectNumberOfPlayersController;
import gui.view.AbstractView;
import gui.view.SelectNumberOfPlayersView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
    private List<AbstractView> views;
    private SelectNumberOfPlayersView selectNumberOfPlayersView;
    private SelectNumberOfPlayersController selectNumberOfPlayersController;

    public void startGame() {
        initializeViews();
        initializeControllers();
        addViewsToControllers();
        addViewsToFrame();
        startMainFrame();
    }

    private void startMainFrame() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        SwingUtilities.invokeLater(
                () -> new MainFrame(views));
    }

    private void initializeViews() {
        selectNumberOfPlayersView = new SelectNumberOfPlayersView();
    }

    private void initializeControllers() {
        selectNumberOfPlayersController = (SelectNumberOfPlayersController) ControllerFactory.getController(ControllerFactory.SELECT_NUMBER_OF_PLAYERS);
    }
    private void addViewsToControllers() {
        selectNumberOfPlayersController.setView(selectNumberOfPlayersView);
    }

    private void addViewsToFrame() {
        views = new ArrayList<>();
        views.add(selectNumberOfPlayersView);
    }
}
