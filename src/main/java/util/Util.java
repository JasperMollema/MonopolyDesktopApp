package util;

import model.Player;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static String stringValue(Integer integer) {
        return integer == null ? null : integer.toString();
    }

    public static Player[] toPlayerArray(List<Player> playerList) {
        Player[] playerArray = new Player[playerList.size()];
        for (int i = 0; i < playerList.size(); i++) {
            playerArray[i] = playerList.get(i);
        }
        return playerArray;
    }

    public static Map<String, Integer> toStringIntegerMap(Map<Player, Integer> playerIntegerMap) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (Player player : playerIntegerMap.keySet()) {
            String playerName = player.toString();
            Integer position = playerIntegerMap.get(player);
            stringIntegerMap.put(playerName, position);
        }
        return stringIntegerMap;
    }

    public static ImageIcon createIcon(String imageName) {
        Path path = Paths.get("./src/main/resources/images/" + imageName);
        if (!Files.isRegularFile(path)) {
            return null;
        }
        try {
            URL url = path.toUri().toURL();
            return new ImageIcon(url);
        } catch (MalformedURLException e) {
            System.err.println("Unable to load file " + path);
            return null;
        }
    }
}
