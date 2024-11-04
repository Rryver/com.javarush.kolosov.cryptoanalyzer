package ru.javarush.kolosov.cryptoanalyzer.controllers;

import ru.javarush.kolosov.cryptoanalyzer.Application;
import ru.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

abstract class BaseController {

    public void renderScreen(Scenes scene) {
        Application.getInstance().getSceneManager().renderScene(scene);
    }

    public void toMainScreen() {
        renderScreen(Scenes.MAIN);
    }
}
