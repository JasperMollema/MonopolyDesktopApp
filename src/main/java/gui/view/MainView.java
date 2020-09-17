package gui.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainView extends AbstractView {
    private Map<AbstractView, String> viewMap;
    private CardLayout cardLayout;
    private Container container;
    private final String NAME_VIEW = "MainView";

    public MainView() {
        this.viewMap = new HashMap<>();
    }

    @Override
    public void initializeView() {
        System.out.println(NAME_VIEW + " : initializeView()");
    }

    public void addView(AbstractView abstractView, String identifier) {
        viewMap.put(abstractView, identifier);
        container.add(abstractView, identifier);
    }

    public void showView(String identifier) {
        cardLayout.show(container, identifier);
    }

    @Override
    public String getViewName() {
        return NAME_VIEW;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public void setLayoutToContainer() {
        if (container != null && cardLayout != null) {
            container.setLayout(cardLayout);
        }
    }
}
