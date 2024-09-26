package ru.javarush.kolosov.cryptoanalyzer.analyzers;

import ru.javarush.kolosov.cryptoanalyzer.analyzers.alphabets.Alphabet;

import java.util.Map;

public class CaesarCypher {

    private final Map<Character, Character> alphabet;

    private final int key;

    public CaesarCypher(int key, char[]... alphabets) {
        this.key = key;

        char[] alphabet = Alphabet.merge(alphabets);



        this.alphabet =
    }

    public String encode(String text) {
        char[] textChars = text.toCharArray();

        for (int i = 0; i < textChars.length; i++) {
            textChars[i] = encodeSymbol(textChars[i]);
        }

        return new String(textChars);
    }

    public String decode(String text) {
        return null;
    }


    private char encodeSymbol(char symbol) {

    }
}
