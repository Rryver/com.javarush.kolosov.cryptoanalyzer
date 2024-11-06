package com.javarush.kolosov.cryptoanalyzer.controllers;

import com.javarush.kolosov.cryptoanalyzer.Application;
import com.javarush.kolosov.cryptoanalyzer.exceptions.BruteForceKeyNotFoundException;
import com.javarush.kolosov.cryptoanalyzer.helpers.FileHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import com.javarush.kolosov.cryptoanalyzer.analyzers.CaesarCipherBruteForceDecoder;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Контроллер экрана "шифрования методом BruteForce"
 */
public class BruteForceController extends BaseController {

    private Path inputFile;
    private ArrayList<Path> decodedFiles;

    @FXML
    public Button selectFileBtn;

    @FXML
    public Button submitFormBtn;
    @FXML
    public Label commonHelpBlock;

    @FXML
    public VBox resultBlock;
    @FXML
    public Label labelResult;
    @FXML
    public Button saveFileBtn;

    @FXML
    public void actionSelectFile() {
        File file = FileHelper.showOpenDialog();
        if (file != null) {
            selectFileBtn.setText(file.getAbsoluteFile().toString());
            inputFile = file.toPath();
        }
    }

    @FXML
    public void actionDecodeByBruteForce() {
        hideHelpBlocks();

        if (inputFile == null) {
            commonHelpBlock.setText("Необходимо выбрать файл");
            commonHelpBlock.setVisible(true);
            return;
        }

        Path sourceFile = inputFile;

        try {
            CaesarCipherBruteForceDecoder bruteForceDecoder = new CaesarCipherBruteForceDecoder(Application.alphabets);

            disableInputFields();
            submitFormBtn.setText("Обработка...");

            decodedFiles = bruteForceDecoder.decode(sourceFile);
        } catch (BruteForceKeyNotFoundException exception) {
            commonHelpBlock.setText(exception.getMessage());
            commonHelpBlock.setVisible(true);
            return;
        }

        resultBlock.setVisible(true);
        labelResult.setText(String.format("Обработка успешно завершена. Всего создано %s файлов", decodedFiles.size()));
        if (decodedFiles.isEmpty()) {
            saveFileBtn.setDisable(true);
        }
    }

    @FXML
    public void actionDownloadFiles() {
        if (decodedFiles.isEmpty()) {
            labelResult.setText("Нет файлов, которые нужно сохранить");
            labelResult.setVisible(true);
            return;
        }

        Path savedFile = FileHelper.saveFilesToUserDirectory(inputFile.toFile().getName(), decodedFiles);
        if (savedFile == null) {
            labelResult.setText("Не удалось сохранить файл");
            labelResult.setVisible(true);
            return;
        }

        labelResult.setText(String.format("Файл %s успешно сохранен", savedFile.getFileName()));
        labelResult.setVisible(true);
    }

    private void hideHelpBlocks() {
        commonHelpBlock.setVisible(false);
    }

    private void disableInputFields() {
        submitFormBtn.setDisable(true);
        selectFileBtn.setDisable(true);
    }
}
