package gui.view;

import messages.Messages;

import javax.swing.*;

public abstract class AbstractView extends JPanel implements View {
    private static Messages messages;

    public AbstractView() {
        System.out.println("Constructor View : " + getViewName());
        setVisible(false);
        if (messages == null) {
            messages = new Messages();
        }
        initializeView();
    }

    public abstract String getViewName();

    public String getMessage(String messageResource) {
        return messages.getMessage(messageResource);
    }

    public String getMessage(String messageResource, String ... args) {
        return messages.getMessage(messageResource, args);
    }
}
