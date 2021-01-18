package gui.view;

import java.awt.*;

public class MonopolyGameView extends AbstractView{
    private PlayersView playersView;
    private BoardView boardView;
    private ControlPanelView controlPanelView;

    @Override
    public String getViewName() {
        return "MonopolyGameView";
    }

    @Override
    public void initializeView() {
        System.out.println(getViewName() + " InitializeView()");
    }

    public void showChildViews() {
        setLayout(new BorderLayout());
        add(boardView, BorderLayout.CENTER);
        add(playersView, BorderLayout.EAST);
        add(controlPanelView, BorderLayout.SOUTH);
    }

    public void setPlayersView(PlayersView playersView) {
        this.playersView = playersView;
    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }

    public void setControlPanelView(ControlPanelView controlPanelView) {
        this.controlPanelView = controlPanelView;
    }
}
