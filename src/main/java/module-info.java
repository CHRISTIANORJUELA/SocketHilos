module com.example.sockets_hilos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.sockets_hilos to javafx.fxml;
    exports com.example.sockets_hilos;
    exports com.example.sockets_hilos.controllers;
    opens com.example.sockets_hilos.controllers to javafx.fxml;
}