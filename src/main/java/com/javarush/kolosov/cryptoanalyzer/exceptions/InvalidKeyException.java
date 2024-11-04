package com.javarush.kolosov.cryptoanalyzer.exceptions;

public class InvalidKeyException extends IllegalArgumentException {
    public InvalidKeyException(String message) {
        super(message);
    }

}
