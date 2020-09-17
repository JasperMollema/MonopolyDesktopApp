package gui.controller;

public abstract class AbstractController implements Controller {
    public AbstractController() {
        System.out.println("Constructor Controller : " + getControllerName());
    }

    public abstract String getControllerName();
}
