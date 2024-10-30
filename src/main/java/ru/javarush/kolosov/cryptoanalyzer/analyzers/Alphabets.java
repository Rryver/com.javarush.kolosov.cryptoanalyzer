package ru.javarush.kolosov.cryptoanalyzer.analyzers;

public class Alphabets {
    public static final char[] RU = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    public static final char[] EN = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] SYMBOLS = {' ', '!', '?', ':', '—', '-', ',', '.', '«', '»', '\''};


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
