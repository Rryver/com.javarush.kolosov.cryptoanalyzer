package ru.javarush.kolosov.cryptoanalyzer.frontend;

public enum Scenes {
    MAIN("main.fxml"),
    ENCODE_BY_KEY("encodeByKey.fxml"),
    DECODE_BY_KEY("decodeByKey.fxml"),
    DECODE_BY_BRUTE_FORCE("decodeByBruteForce.fxml");


    private final String sceneName;

    Scenes(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneName() {
        return sceneName;
    }
}
