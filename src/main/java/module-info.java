module com.javarush.kolosov.cryptoanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.javarush.kolosov.cryptoanalyzer to javafx.fxml;
    exports com.javarush.kolosov.cryptoanalyzer;
    exports com.javarush.kolosov.cryptoanalyzer.controllers;
    opens com.javarush.kolosov.cryptoanalyzer.controllers to javafx.fxml;
    exports com.javarush.kolosov.cryptoanalyzer.helpers;
    opens com.javarush.kolosov.cryptoanalyzer.helpers to javafx.fxml;
    exports com.javarush.kolosov.cryptoanalyzer.frontend;
    opens com.javarush.kolosov.cryptoanalyzer.frontend to javafx.fxml;
}