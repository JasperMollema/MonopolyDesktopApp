package gui.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainView extends AbstractView {
    private Map<AbstractView, String> viewMap;
    private CardLayout cardLayout;
    private final String NAME_VIEW = "MainView";

    public MainView() {
        this.viewMap = new HashMap<>();
        this.cardLayout = new CardLayout();
    }

    @Override
    public void initializeView() {
        System.out.println(NAME_VIEW + " : initializeView()");
    }

    public void addView(AbstractView abstractView, String identifier) {
        viewMap.put(abstractView, identifier);
        add(abstractView, identifier);
    }

    public void showView(String identifier) {
        cardLayout.show(this, identifier);
    }

    @Override
    public String getViewName() {
        return NAME_VIEW;
    }
}
