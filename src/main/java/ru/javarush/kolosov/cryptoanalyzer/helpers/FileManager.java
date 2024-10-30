package ru.javarush.kolosov.cryptoanalyzer.helpers;

import javafx.stage.FileChooser;
import ru.javarush.kolosov.cryptoanalyzer.Application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static boolean isFileExists(Path file) {
        return Files.exists(file);
    }

    public static File openFile() {
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(Application.getInstance().getPrimaryStage());
    }

    public static Path saveFile(Path source) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(source.getFileName().toString());
        File file = fileChooser.showSaveDialog(Application.getInstance().getPrimaryStage());

        if (file != null) {
            try {
                Files.deleteIfExists(file.toPath());
                return Files.copy(source, file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}
