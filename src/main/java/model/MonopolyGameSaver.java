package model;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.stream.Collectors;

public class MonopolyGameSaver {
    private static final String SAVED_GAMES_DIRECTORY = "./monopolyGame/saved-games";
    private static final String SEPARATOR = "/";
    private static final String POST_FIX = ".mo";

    public void saveMonopolyGame(MonopolyGame monopolyGame, String name) throws IOException {
        createDirectoryIfDoesNotExist();
        Path savedGame = createPathFromName(name);

        if (Files.isRegularFile(savedGame)) {
            Files.delete(savedGame);
        }

        Files.createFile(savedGame);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(

                new BufferedOutputStream(new FileOutputStream(savedGame.toFile())))) {
            objectOutputStream.writeObject(monopolyGame);
        }
    }

    public MonopolyGame loadMonopolyGame(String nameGame) throws IOException, ClassNotFoundException {
        MonopolyGame monopolyGame = null;
        Path path = createPathFromName(nameGame);
        File gameToLoad = path.toFile();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(gameToLoad))
        )){
            while (true) {
                 Object object = objectInputStream.readObject();
                 if (object instanceof MonopolyGame) {
                     monopolyGame = (MonopolyGame) object;
                 }
            }
        } catch (EOFException eofException) {

        }
        return monopolyGame;
    }

    public void deleteMonopolyGame(String nameGame) throws IOException {
        Path path = createPathFromName(nameGame);
        if (Files.isRegularFile(path)) {
            Files.delete(path);
        }
    }

    private Path createPathFromName(String name) {
        return Paths.get(SAVED_GAMES_DIRECTORY + SEPARATOR + name + POST_FIX);
    }

    public Map<String, BasicFileAttributes> loadGames() throws IOException {
        Map<String, BasicFileAttributes> savedGames;
        createDirectoryIfDoesNotExist();
        Path savedGamesDirectory = Paths.get(SAVED_GAMES_DIRECTORY);
            savedGames = Files.walk(savedGamesDirectory)
                    .filter(path -> path.toString().endsWith(POST_FIX))
                    .collect(Collectors.toMap(this::createNameFromPath, this::createFileAttributesFromPath));
        return savedGames;
    }

    private String createNameFromPath(Path path) {
        String name = path.toString();
        String savedGamesDirectory = Paths.get(SAVED_GAMES_DIRECTORY).toString().concat(FileSystems.getDefault().getSeparator());
        if (!name.contains(savedGamesDirectory) || !name.endsWith(POST_FIX)) {
            return null;
        }
        name = name.replace(savedGamesDirectory, "").replace(POST_FIX, "");

        return name;
    }

    private BasicFileAttributes createFileAttributesFromPath(Path path) {
        try {
            return Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    private void createDirectoryIfDoesNotExist() throws IOException {
        Path savedGames = Paths.get(SAVED_GAMES_DIRECTORY);
        if (!Files.exists(savedGames)) {
            Files.createDirectories(savedGames);
        }
    }

}
