package ru.javarush.kolosov.cryptoanalyzer.analyzers.alphabets;

import java.util.Arrays;
import java.util.stream.Stream;

public class Alphabet {
    public static final char[] RU = {'А', 'Б'};
    public static final char[] EN = {'A', 'B'};
    public static final char[] SYMBOLS = {' ', '!', '?', ':'};


    public static char[] merge(char[]... alphabets) {
        int length = 0;
        for (char[] alphabet : alphabets) {
            length += alphabet.length;
        }
        char[] result = new char[length];

        int index = 0;
        for (char[] alphabet : alphabets) {
            System.arraycopy(alphabet, 0, result, index, alphabet.length);
            index += alphabet.length;
        }

        return result;
    }
}
