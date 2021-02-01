package model;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;

    public Player(String name) {
        this.name = name;
    }

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
}
