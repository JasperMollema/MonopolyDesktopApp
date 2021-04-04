package model;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String color;
    private boolean isComputer;

    public Player(String name, String color, boolean isComputer) {
        this.name = name;
        this.color = color;
        this.isComputer = isComputer;
    }

    public Player() {}

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        Player playerToBeCompared = (Player) obj;
        return playerToBeCompared.name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isComputer() {
        return isComputer;
    }
}
