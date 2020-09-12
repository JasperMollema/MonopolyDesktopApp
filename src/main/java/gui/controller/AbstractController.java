package gui.controller;

public abstract class AbstractController implements Controller {
    public AbstractController() {
        System.out.println("Start Controller : " + getControllerName());
    }

    public abstract String getControllerName();
}
