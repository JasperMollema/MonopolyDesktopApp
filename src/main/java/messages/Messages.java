package messages;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private static Locale locale;

    public Messages() {
        if (locale == null) {
            locale = new Locale("nl");
        }
    }

    public static String getMessage(String messageResource) {
        return ResourceBundle
                .getBundle("monopoly", locale)
                .getString(messageResource);
    }

    public static String getMessage(String messageResource, String ... args) {
        String format = getMessage(messageResource);

        return MessageFormat.format(format, args);
    }
}
