package model;

import java.util.HashMap;

public class PlayerPositionMap extends HashMap<Player, Integer> {
    private HashMap<String, Integer> stringIntegerHashMap;

    public PlayerPositionMap() {
        stringIntegerHashMap = new HashMap<>();
    }

    @Override
    public Integer put(Player key, Integer value) {
        stringIntegerHashMap.put(key.toString(), value);
        return super.put(key, value);
    }

    @Override
    public Integer get(Object key) {
        Integer integer = super.get(key);

        if (integer == null) {
            integer = stringIntegerHashMap.get(key.toString());
        }

        return integer;
    }
}
