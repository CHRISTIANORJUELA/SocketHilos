package com.example.sockets_hilos.utils;

import javafx.scene.control.Alert;

public class PrintMessage {
    public static void redMessage(String header, String content){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText(header);
        a.setContentText(content);
        a.showAndWait();
    }
}
