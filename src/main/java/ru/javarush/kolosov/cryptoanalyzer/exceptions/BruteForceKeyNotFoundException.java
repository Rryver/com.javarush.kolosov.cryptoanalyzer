package ru.javarush.kolosov.cryptoanalyzer.exceptions;

public class BruteForceKeyNotFoundException extends RuntimeException {

    public BruteForceKeyNotFoundException() {
        super("Не удалось определить ключ");
    }
}
