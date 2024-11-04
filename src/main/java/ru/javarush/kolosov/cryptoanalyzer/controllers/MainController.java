package ru.javarush.kolosov.cryptoanalyzer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ru.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

public class MainController extends BaseController {

    @FXML
    public Button toEncodeByKeyBtn;
    @FXML
    public Button toDecodeByKeyBtn;
    @FXML
    public Button toDecodeByBruteForceBtn;

    @FXML
    public void openEncodeByKeyScreen() {
        renderScreen(Scenes.ENCODE_BY_KEY);
    }

    @FXML
    public void openDecodeByKeyScreen() {
        renderScreen(Scenes.DECODE_BY_KEY);
    }

    @FXML
    public void openDecodeByBruteForceScreen() {
        renderScreen(Scenes.DECODE_BY_BRUTE_FORCE);
    }
}
