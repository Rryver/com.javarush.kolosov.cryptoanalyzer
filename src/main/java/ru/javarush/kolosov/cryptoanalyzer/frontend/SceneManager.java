package ru.javarush.kolosov.cryptoanalyzer.frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class SceneManager {

    private final Stage primaryStage;

    private final Stack<Scene> scenesStack = new Stack<>();

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene loadScene(Scenes scene) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(String.format("/ru/javarush/kolosov/cryptoanalyzer/%s", scene.getSceneName())));
        Parent root = null;

        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Scene(root);
    }

    public void renderScene(Scenes scene) {
        Scene loadedScene = loadScene(scene);
        primaryStage.setScene(loadedScene);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
