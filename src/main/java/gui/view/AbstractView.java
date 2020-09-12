package gui.view;

import messages.Messages;

import javax.swing.*;

public abstract class AbstractView extends JPanel implements View {
    private Messages messages;

    public AbstractView() {
        messages = new Messages();
    }

    public String getMessage(String messageResource) {
        return messages.getMessage(messageResource);
    }

    public String getMessage(String messageResource, String ... args) {
        return messages.getMessage(messageResource, args);
    }
}
