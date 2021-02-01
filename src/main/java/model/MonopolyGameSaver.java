package model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MonopolyGameSaver {
    private static final String SAVED_GAMES_DIRECTORY = "./monopolyGame/saved-games";

    public void saveMonopolyGame(MonopolyGame monopolyGame, String name) throws IOException {
        createDirectoryIfDoesNotExist();
        Path savedGame = Paths.get(SAVED_GAMES_DIRECTORY + "/" + name + ".mo");

        if (!Files.isRegularFile(savedGame)) {
            Files.createFile(savedGame);
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(savedGame.toFile())))) {
            objectOutputStream.writeObject(monopolyGame);
        }
    }

    private void createDirectoryIfDoesNotExist() throws IOException{
        Path savedGames = Paths.get(SAVED_GAMES_DIRECTORY);
        if (!Files.exists(savedGames)) {
            Files.createDirectories(savedGames);
        }
    }
}
