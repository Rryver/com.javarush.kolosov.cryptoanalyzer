package com.javarush.kolosov.cryptoanalyzer.analyzers;

public class Validator {
    public static boolean validateKeyRange(int key, char[] alphabet) {
        return key != 0 && Math.abs(key) < alphabet.length;
    }

    public static boolean validateAlphabet(char[] alphabet) {
        return alphabet.length != 0;
    }
}
