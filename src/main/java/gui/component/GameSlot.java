package gui.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameSlot {
    private String name;
    private LocalDateTime localDateTime;
    private DateTimeFormatter dateTimeFormatter;
    private boolean isEmptySlot;

    public GameSlot(String name, LocalDateTime localDateTime) {
        this.name = name;
        this.localDateTime = localDateTime;
        dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy kk:mm");
    }

    public GameSlot(String name, boolean isEmptySlot) {
        this(name, null);
        this.isEmptySlot = isEmptySlot;
    }


    public String getTime() {
        return isEmptySlot ? "" : localDateTime.format(dateTimeFormatter);
    }

    public String getName() {
        return name;
    }

    public boolean isEmptySlot() {
        return isEmptySlot;
    }
}
