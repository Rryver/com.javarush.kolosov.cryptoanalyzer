package com.javarush.kolosov.cryptoanalyzer.analyzers;

import com.javarush.kolosov.cryptoanalyzer.exceptions.InvalidFileException;
import com.javarush.kolosov.cryptoanalyzer.helpers.FileHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CaesarCipherBruteForceDecoder {
    private final String[] validationRegExs = {"[.,-:]\\s\\S"};

    private final char[][] alphabets;

    public CaesarCipherBruteForceDecoder(char[]... alphabets) {
        this.alphabets = alphabets;
    }

    public ArrayList<Path> decode(Path sourceFile) {
        if (!Files.exists(sourceFile)) {
            throw new InvalidFileException("Исходного файла не существует");
        }

        ArrayList<Path> decodedFiles = new ArrayList<>();

        for (int key = 1; key < Alphabets.merge(alphabets).length; key++) {
            CaesarCipher caesarCipher = new CaesarCipher(key, alphabets);

            Path decodedFile = Path.of(String.format("%s/bruteForce_%d_%s", FileHelper.fileStorageName, key, sourceFile.getFileName()));
            try (BufferedReader reader = Files.newBufferedReader(sourceFile);
                 BufferedWriter writer = Files.newBufferedWriter(decodedFile)) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    line = caesarCipher.decode(line);
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            decodedFiles.add(decodedFile);
        }

        return decodedFiles;
    }

//    private boolean validateFile(Path str) {
//        for (String regEx : validationRegExs) {
//            Pattern pattern = Pattern.compile(regEx);
//            Matcher matcher = pattern.matcher(str);
//
//            if (matcher.find()) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
