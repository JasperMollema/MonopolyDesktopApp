package gui.view;

public class MonopolyGameView extends AbstractView {
    private PlayersView playersView;

    @Override
    public String getViewName() {
        return "MonopolyGameView";
    }

    @Override
    public void initializeView() {
        System.out.println(getViewName() + " InitializeView()");
    }

    public void showChildViews() {
        add(playersView);
    }

    public void setPlayersView(PlayersView playersView) {
        this.playersView = playersView;
    }
}
