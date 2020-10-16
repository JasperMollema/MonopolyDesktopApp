package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer {
    String name = "name";
    String differentName = "differentName";
    Player player1;
    Player player2;

    @Test
    void testEqualsMethodSameName() {
        player1 = new Player(name);
        player2 = new Player(name);
        assertTrue(player1.equals(player2));
    }

    @Test
    void testEqualsMethodDifferentName() {
        player1 = new Player(name);
        player2 = new Player(differentName);
        assertFalse(player1.equals(player2));
    }

    @Test
    void testEqualsMethodNotAPlayer() {
        player1 = new Player(name);
        Object obj = new Object();
        assertFalse(player1.equals(obj));
    }
}
