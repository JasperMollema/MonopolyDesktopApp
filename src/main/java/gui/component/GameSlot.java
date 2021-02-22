package gui.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameSlot {
    private String name;
    private LocalDateTime localDateTime;
    private DateTimeFormatter dateTimeFormatter;
    private boolean isEmptySlot;

    public GameSlot(String name) {
        this.name = name;
        updateTime();
        dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy kk:mm");
    }

    public GameSlot(String name, boolean isEmptySlot) {
        this(name);
        this.isEmptySlot = isEmptySlot;
    }

    public void updateTime() {
        if (!isEmptySlot) {
            localDateTime = LocalDateTime.now();
        }
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
