package com.example.sockets_hilos.controllers;

import com.example.sockets_hilos.services.EmployeeConection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    @FXML
    private TextArea textArea;

    @FXML
    private TextField tfHost;

    @FXML
    private TextField tfPort;

    @FXML
    private TextField tfUser;

    /**
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.setPrefColumnCount(2000);
        textArea.setPrefRowCount(2000);
    }

    @FXML
    void btnConectServer(ActionEvent event) {
        String nameUser = tfUser.getText();
        String host = tfHost.getText();
        String port = tfPort.getText();
        if (nameUser != null && host != null && port != null) {
            EmployeeConection employeeConection = new EmployeeConection();
            employeeConection.addParameters(nameUser, host, port, textArea);
        }

    }
}

