package ru.javarush.kolosov.cryptoanalyzer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.javarush.kolosov.cryptoanalyzer.Application;
import ru.javarush.kolosov.cryptoanalyzer.analyzers.CaesarCipherBruteForceDecoder;
import ru.javarush.kolosov.cryptoanalyzer.exceptions.BruteForceKeyNotFoundException;
import ru.javarush.kolosov.cryptoanalyzer.helpers.FileManager;

import java.io.File;
import java.nio.file.Path;

public class BruteForceController extends BaseController {

    private Path inputFile;
    private Path outputFile;

    @FXML
    public Button selectFileBtn;

    @FXML
    public Button submitBtn;
    @FXML
    public Label commonHelpBlock;

    @FXML
    public VBox resultBlock;
    @FXML
    public Label labelResult;
    @FXML
    public Button saveFileBtn;

    @FXML
    public void selectFile() {
        File file = FileManager.openFile();
        if (file != null) {
            selectFileBtn.setText(file.getAbsoluteFile().toString());
            inputFile = file.toPath();
        }
    }

    @FXML
    public void decodeByBruteForce() {
        hideHelpBlocks();

        if (inputFile == null) {
            commonHelpBlock.setText("Необходимо выбрать файл");
            commonHelpBlock.setVisible(true);
            return;
        }

        Path sourceFile = inputFile;
        Path encodedFile = Path.of("files/encoded_" + inputFile.getFileName());

        try {
            CaesarCipherBruteForceDecoder bruteForceDecoder = new CaesarCipherBruteForceDecoder(Application.alphabets);

            disableInputFields();
            submitBtn.setText("Обработка...");

            bruteForceDecoder.decode(sourceFile, encodedFile);
        } catch (BruteForceKeyNotFoundException exception) {
            commonHelpBlock.setText(exception.getMessage());
            commonHelpBlock.setVisible(true);
            return;
        }

        outputFile = encodedFile;
        resultBlock.setVisible(true);
        labelResult.setText("Обработка завершена");
    }

    @FXML
    public void downloadFile() {
        if (outputFile == null) {
            return;
        }

        Path savedFile = FileManager.saveFile(outputFile);

        if (savedFile == null) {
            labelResult.setText("Не удалось сохранить файл");
            labelResult.setVisible(true);
            return;
        }

        labelResult.setText("Файл " + savedFile.getFileName() + " успешно сохранен");
        labelResult.setVisible(true);
    }

    private void hideHelpBlocks() {
        commonHelpBlock.setVisible(false);
    }

    private void clearSubmitBtn() {
        submitBtn.setText("Зашифровать");
        submitBtn.setDisable(false);
    }

    private void clearFields() {
        inputFile = null;
        selectFileBtn.setText("Выбрать файл");
    }

    private void clearResults() {
        labelResult.setText(null);
        resultBlock.setVisible(false);
    }

    private void clearForm() {
        hideHelpBlocks();
        clearSubmitBtn();
        clearFields();
        clearResults();
    }

    private void disableInputFields() {
        submitBtn.setDisable(true);
        selectFileBtn.setDisable(true);
    }
}
