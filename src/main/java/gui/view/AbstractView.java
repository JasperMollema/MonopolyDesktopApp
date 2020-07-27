package gui.view;

import javax.swing.*;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class AbstractView extends JPanel implements View {
    public static Locale locale;

    public AbstractView() {
        if (locale == null) {
            locale = new Locale("nl");
        }
    }

    public String getMessage(String messageResource) {
        return ResourceBundle
                .getBundle("monopoly", locale)
                .getString(messageResource);
    }

    public String getMessage(String messageResource, String ... args) {
        String format = getMessage(messageResource);

        return MessageFormat.format(format, args);
    }
}
