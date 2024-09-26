package ru.javarush.kolosov.cryptoanalyzer.analyzers;

import ru.javarush.kolosov.cryptoanalyzer.analyzers.alphabets.Alphabet;

public class CezarCypher {

    private final char[] alphabet;

    private final int key;

    public CezarCypher(int key, char[]... alphabets) {
        this.key = key;
        this.alphabet = Alphabet.merge(alphabets);
    }

    public String encode(String text) {
        return null;
    }

    public String decode(String text) {
        return null;
    }
}
