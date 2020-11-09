package gui.view;

import java.awt.*;

public class MonopolyGameView extends AbstractGridBagView {
    private PlayersView playersView;
    private BoardView boardView;

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
        initializeGridBagConstraints();
        addComponentToGridBagConstraints(playersView, 2, 1);
        addComponentToGridBagConstraints(boardView, 1, 1);
    }

    public void setPlayersView(PlayersView playersView) {
        this.playersView = playersView;
    }

    public void setBoardView(BoardView boardView) {
        this.boardView = boardView;
    }
}
