package gui.view;

public class MenuView extends AbstractView {
    private final String NAME_VIEW = "MenuView";

    @Override
    public void initializeView() {
        System.out.println(NAME_VIEW + " : initializeView()");
    }

    @Override
    public String getViewName() {
        return NAME_VIEW;
    }
}
