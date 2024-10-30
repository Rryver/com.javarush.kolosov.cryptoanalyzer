package ru.javarush.kolosov.cryptoanalyzer.analyzers;

import ru.javarush.kolosov.cryptoanalyzer.exceptions.BruteForceKeyNotFoundException;
import ru.javarush.kolosov.cryptoanalyzer.exceptions.InvalidFileException;
import ru.javarush.kolosov.cryptoanalyzer.helpers.FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaesarCipherBruteForceDecoder {
    private final String[] validationRegExs = {"[.,-:]\\s\\S"};

    private final CaesarCipher caesarCipher;

    public CaesarCipherBruteForceDecoder(char[]... alphabets) {
        caesarCipher = new CaesarCipher(1, alphabets);
    }

    public String decode(String str) {
        for (int key = 1; key < caesarCipher.getSourceAlphabet().length; key++) {
            caesarCipher.setKey(key);
            String decodedStr = caesarCipher.decode(str);

            if (validateString(decodedStr)) {
                return decodedStr;
            }
        }

        throw new BruteForceKeyNotFoundException();
    }

    public void decode(Path sourceFile, Path outputFile) {
        if (!FileManager.isFileExists(sourceFile)) {
            throw new InvalidFileException("Исходного файла не существует");
        }

        try (BufferedReader reader = Files.newBufferedReader(sourceFile);
             BufferedWriter writer = Files.newBufferedWriter(outputFile)) {

            boolean textValidated = false;
            for (int key = 1; key < caesarCipher.getSourceAlphabet().length; key++) {
                caesarCipher.setKey(key);

                while (reader.ready()) {
                    String line = reader.readLine();
                    line = this.caesarCipher.decode(line);
                    writer.write(line);
                    writer.newLine();

                    if (!textValidated) {
                        textValidated = validateString(line);
                    }
                }

                if (textValidated) {
                    return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        throw new BruteForceKeyNotFoundException();
    }

    private boolean validateString(String str) {
        for (String regEx : validationRegExs) {
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(str);

            if (matcher.find()) {
                return true;
            }
        }

        return false;
    }
}
