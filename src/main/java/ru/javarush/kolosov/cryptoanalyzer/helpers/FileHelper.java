package ru.javarush.kolosov.cryptoanalyzer.helpers;

import javafx.stage.FileChooser;
import ru.javarush.kolosov.cryptoanalyzer.Application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileHelper {
    public static final String fileStorageName = "files";

    public static File showOpenDialog() {
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(Application.getInstance().getSceneManager().getPrimaryStage());
    }

    public static File showSaveDialog(String initialFileName) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(initialFileName);
        return fileChooser.showSaveDialog(Application.getInstance().getSceneManager().getPrimaryStage());
    }

    public static Path saveFile(Path source) {
        File file = showSaveDialog(source.getFileName().toString());

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

    public static Path saveFiles(String outputZipName, ArrayList<Path> files) {
        Path zipFile = zipFiles(outputZipName, files);
        if (zipFile == null) {
            return null;
        }

        File file = showSaveDialog(zipFile.getFileName().toString());
        if (file != null) {
            try {
                Files.deleteIfExists(file.toPath());
                return Files.copy(zipFile, file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    public static Path zipFiles(String outputZipName, ArrayList<Path> files) {
        if (files.isEmpty()) {
            return null;
        }

        Path outputZipFile = Path.of(String.format("%s/%s.zip", fileStorageName, outputZipName));
        try (final FileOutputStream fos = new FileOutputStream(outputZipFile.toFile());
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            for (Path fileToZip : files) {
                FileInputStream fis = new FileInputStream(fileToZip.toFile());
                ZipEntry zipEntry = new ZipEntry(fileToZip.getFileName().toString());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length = fis.read(bytes);
                while (length >= 0) {
                    zipOut.write(bytes, 0, length);
                    length = fis.read(bytes);
                }
                fis.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return outputZipFile;
    }
}
