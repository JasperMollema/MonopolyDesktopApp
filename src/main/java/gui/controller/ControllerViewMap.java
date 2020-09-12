package gui.controller;

import gui.view.AbstractView;

import java.util.HashMap;
import java.util.Map;

public class ControllerViewMap {
    private static Map<AbstractController, AbstractView> controllerViewMap;

    {
        controllerViewMap = new HashMap<>();
        fillControllerViewMap();
    }

    private void fillControllerViewMap() {

    }

    public static AbstractView getView(AbstractController controller) {
        return controllerViewMap.get(controller);
    }
}
