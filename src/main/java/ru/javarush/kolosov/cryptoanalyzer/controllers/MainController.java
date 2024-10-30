package ru.javarush.kolosov.cryptoanalyzer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ru.javarush.kolosov.cryptoanalyzer.Application;
import ru.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

import java.io.IOException;

public class MainController extends BaseController {

    @FXML
    public Button toEncodeByKeyBtn;
    @FXML
    public Button toDecodeByKeyBtn;
    @FXML
    public Button toDecodeByBruteForceBtn;

    @FXML
    public void openEncodeByKeyScreen() {
        try {
            Application.getInstance().switchScene(Scenes.ENCODE_BY_KEY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void openDecodeByKeyScreen() {
        try {
            Application.getInstance().switchScene(Scenes.DECODE_BY_KEY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void openDecodeByBruteForceScreen() {
        try {
            Application.getInstance().switchScene(Scenes.DECODE_BY_BRUTE_FORCE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
