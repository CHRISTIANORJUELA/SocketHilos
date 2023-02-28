package com.example.sockets_hilos.services;

import com.example.sockets_hilos.utils.MessageBar;
import com.example.sockets_hilos.utils.PrintMessage;
import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

public class EmployeeConection {
    private Socket socket;
    private String user;
    private String host;
    private String port;

    private TextArea textArea;
    private DataInputStream dataInputStream;

    public void addParameters(String user, String host, String port, TextArea textArea){
        this.user = user;
        this.host = host;
        this.port = port;
        this.textArea = textArea;
        liftConection();
    }

    public void liftConection(){
        try {
            this.socket = new Socket(this.host, Integer.parseInt(this.port));
            flush();
        }catch (IOException e){
            PrintMessage.redMessage(MessageBar.ERROR.getMensaje(), MessageBar.HUBOUNPROBLEMAENCONECTARCONELSERVIDOR.getMensaje());
        }

    }

    public void flush(){
        try {
            dataInputStream = new DataInputStream(this.socket.getInputStream());
            CompletableFuture.runAsync(this::listenOrders);
        }catch (IOException e){
            PrintMessage.redMessage(MessageBar.ERROR.getMensaje(),"Hubo un problema en crear canal de datos");
        }
    }

    public void listenOrders(){
        try {
            String message;
            while (true){
                message = dataInputStream.readUTF();
                System.out.println("El mensaje es : "+message);
                textArea.appendText(message+System.lineSeparator());
            }
        }catch (IOException e){
            System.out.println(e);
            PrintMessage.redMessage(MessageBar.ERROR.getMensaje(),MessageBar.HUBOUNPROBLEMAENRECIBIRLOSDATOS.getMensaje());
        }
    }
}
