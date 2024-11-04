module ru.javarush.kolosov.cryptoanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens ru.javarush.kolosov.cryptoanalyzer to javafx.fxml;
    exports ru.javarush.kolosov.cryptoanalyzer;
    exports ru.javarush.kolosov.cryptoanalyzer.controllers;
    opens ru.javarush.kolosov.cryptoanalyzer.controllers to javafx.fxml;
    exports ru.javarush.kolosov.cryptoanalyzer.helpers;
    opens ru.javarush.kolosov.cryptoanalyzer.helpers to javafx.fxml;
    exports ru.javarush.kolosov.cryptoanalyzer.frontend;
    opens ru.javarush.kolosov.cryptoanalyzer.frontend to javafx.fxml;
}