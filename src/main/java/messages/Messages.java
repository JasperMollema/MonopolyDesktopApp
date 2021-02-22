package messages;

import java.text.MessageFormat;
import java.util.*;

public class Messages {
    private static Locale locale;
    private final static List<String> LOCALES = Arrays.asList("en", "nl");

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

    public static List<String> getAllValues(String messageResource) {
        Locale currentLocale = locale;
        List<String> values = new ArrayList<>();
        for (String localeValue : LOCALES) {
            locale = new Locale(localeValue);
            values.add(getMessage(messageResource));
        }
        locale = currentLocale;
        return values;
    }
}
