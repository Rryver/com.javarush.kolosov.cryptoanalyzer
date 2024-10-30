package ru.javarush.kolosov.cryptoanalyzer.exceptions;

public class InvalidFileException extends IllegalArgumentException {
    public InvalidFileException(String message) {
        super(message);
    }

}
