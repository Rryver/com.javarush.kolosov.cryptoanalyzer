package ru.javarush.kolosov.cryptoanalyzer.controllers;

import ru.javarush.kolosov.cryptoanalyzer.Application;
import ru.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

import java.io.IOException;

abstract class BaseController {

    public void toMainScreen() {
        try {
            Application.getInstance().switchScene(Scenes.MAIN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
