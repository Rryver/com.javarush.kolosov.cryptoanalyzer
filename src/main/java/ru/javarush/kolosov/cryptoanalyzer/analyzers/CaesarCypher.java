package ru.javarush.kolosov.cryptoanalyzer.analyzers;

import ru.javarush.kolosov.cryptoanalyzer.analyzers.alphabets.Alphabet;

import java.util.HashMap;
import java.util.Map;

public class CaesarCypher {

    private final Map<Character, Character> alphabet = new HashMap<>();

    private final int key;

    public CaesarCypher(int key, char[]... alphabets) {
        this.key = key;
        char[] alphabet = Alphabet.merge(alphabets);
        prepareAlphabet(key, alphabet);
        System.out.println(this.alphabet.toString());
    }

    // 0 1 2 3 4 5
    // key = 2
    // 2 3 4 5 0 1
    private void prepareAlphabet(int key, char[] alphabet) {
        for (int i = 0; i < alphabet.length - key; i++) {
            this.alphabet.put(alphabet[i], alphabet[i + key]);
        }

        int startFrom = alphabet.length - key;
        for (int i = startFrom; i < alphabet.length; i++) {
            this.alphabet.put(alphabet[i], alphabet[i - startFrom]);
        }
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
        return alphabet.containsKey(symbol) ? alphabet.;
    }
}
