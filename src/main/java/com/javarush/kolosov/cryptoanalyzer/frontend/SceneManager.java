package com.javarush.kolosov.cryptoanalyzer.frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private final Stage primaryStage;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene loadScene(Scenes scene) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(String.format("/scenes/%s", scene.getSceneName())));
        Parent root;

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
