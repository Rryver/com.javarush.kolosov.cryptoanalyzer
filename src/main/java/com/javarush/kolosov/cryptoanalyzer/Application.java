package com.javarush.kolosov.cryptoanalyzer;

import com.javarush.kolosov.cryptoanalyzer.analyzers.Alphabets;
import com.javarush.kolosov.cryptoanalyzer.frontend.SceneManager;
import javafx.stage.Stage;
import com.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

public class Application extends javafx.application.Application {

    private static Application application;
    private SceneManager sceneManager;

    public static final char[][] alphabets = {Alphabets.RU, Alphabets.EN, Alphabets.SYMBOLS};

    public Application() {
        application = this;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.sceneManager = new SceneManager(primaryStage);
        primaryStage.setTitle("КриптоАнализатор");
        this.sceneManager.renderScene(Scenes.MAIN);
        primaryStage.show();
    }

    public static Application getInstance() {
        return application;
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
