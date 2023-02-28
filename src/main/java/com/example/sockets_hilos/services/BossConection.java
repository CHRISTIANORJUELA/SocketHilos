package com.example.sockets_hilos.services;

import com.example.sockets_hilos.utils.MessageBar;
import com.example.sockets_hilos.utils.PrintMessage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BossConection {
    private DataOutputStream dataOutputStream;
    private Socket socket;

    private int port;
    public BossConection(Socket socket, int port){
        this.socket = socket;
        this.port = port;
        flush(this.socket);
    }

    public void flush(Socket socket){
        try {
          dataOutputStream = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            System.out.println(e);
            PrintMessage.redMessage(MessageBar.ERROR.getMensaje(), MessageBar.HUBOUNPROBLEMAECERRARLACOMUNICACION.getMensaje());
        }

        CompletableFuture.runAsync(this::sendOrders);
    }

    public void sendOrders(){
        List<String> orders = Arrays.asList("Cree una funcion nueva "," Agregue programación funcinal "
                , " Implemente el Model factory", " Agregue Hilos ",
                "Haga una interfaz grafica", "Use Css",
                " Use bootstrap", "Haga una lista",
                 "Use un paquete controladores en su servicio ", "Convierta un String a numero",
                 "Recorra una lista ","Use el patron Builder",
                 "Implemente interfaces","Controle las expeciones",
                  "Ordene el codigo","Pase valores por parametros",
                   "Haga commit del trabajo ","Use la terminal",
                    "Use el patron Stage","Use el patron Brigde");
        boolean conected = true;
        while (conected){
            try {
                int numRamdom = (int)(Math.random()*19);
                String message = orders.get(numRamdom);
                System.out.println("El mensaje para enviar es : "+message+" del puerto : "+socket.getPort());
                Thread.sleep(1500);
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            }catch (Exception e2x) {
                System.out.println(e2x);
                conected = false;
                try {
                    dataOutputStream.close();
                } catch (IOException ex2) {
                    System.out.println(ex2);
                }
            }
        }
    }

    public int getPort() {
        return port;
    }
}
