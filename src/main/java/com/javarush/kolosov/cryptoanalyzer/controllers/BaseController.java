package com.javarush.kolosov.cryptoanalyzer.controllers;

import com.javarush.kolosov.cryptoanalyzer.Application;
import com.javarush.kolosov.cryptoanalyzer.frontend.Scenes;

abstract class BaseController {

    public void renderScreen(Scenes scene) {
        Application.getInstance().getSceneManager().renderScene(scene);
    }

    public void toMainScreen() {
        renderScreen(Scenes.MAIN);
    }
}
