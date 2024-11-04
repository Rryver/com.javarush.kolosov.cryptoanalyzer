package com.javarush.kolosov.cryptoanalyzer.analyzers;

public interface Cipher {

    String encode(String text);
    String decode(String text);
}
