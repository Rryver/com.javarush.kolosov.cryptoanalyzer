package ru.javarush.kolosov.cryptoanalyzer;


import ru.javarush.kolosov.cryptoanalyzer.analyzers.CaesarCypher;
import ru.javarush.kolosov.cryptoanalyzer.analyzers.alphabets.Alphabet;

public class Main {
    public static void main(String[] args) {
        CaesarCypher caesarCypher = new CaesarCypher(1, Alphabet.RU, Alphabet.SYMBOLS);

        String encoded = caesarCypher.encode("message qwe");
        System.out.println(encoded);
    }
}