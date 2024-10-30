package ru.javarush.kolosov.cryptoanalyzer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.javarush.kolosov.cryptoanalyzer.analyzers.Alphabets;
import ru.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static Application application;

    private Stage primaryStage;

    public static final char[][] alphabets = {Alphabets.RU, Alphabets.EN, Alphabets.SYMBOLS};

    public Application() {
        application = this;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("КриптоАнализатор");

        this.switchScene(Scenes.MAIN);

        primaryStage.show();
    }

    public static Application getInstance() {
        return application;
    }

    public void switchScene(Scenes scene) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/javarush/kolosov/cryptoanalyzer/" + scene.getSceneName()));
        Parent root = fxmlLoader.load();
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
