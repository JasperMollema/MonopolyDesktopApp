package messages;

import java.text.MessageFormat;
import java.util.*;

public class Messages {
    private static Locale locale;
    public final static List<Locale> LOCALES = Arrays.asList(
            new Locale("en"),
            new Locale("nl")
    );

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
        for (Locale newLocale : LOCALES) {
            locale = newLocale;
            values.add(getMessage(messageResource));
        }
        locale = currentLocale;
        return values;
    }

    public static void changeLocale(Locale newLocale) {
        if (LOCALES.contains(newLocale)) {
            locale = newLocale;
        }
    }

    public static Locale getLocale() {
        return locale;
    }
}
