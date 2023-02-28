package com.example.sockets_hilos;

import com.example.sockets_hilos.services.BossConection;
import com.example.sockets_hilos.utils.PrintMessage;
import java.net.ServerSocket;
import java.net.Socket;

public class StartBoss {
    public static void main(String[] args){
        int port = 9999;
        int maxConection = 10;
        ServerSocket serverSocket = null;
        Socket socket;

        try {
            serverSocket = new ServerSocket(port,maxConection);
            while (true){
                System.out.println("Esperando empleados");
                socket = serverSocket.accept();
                System.out.println("Empleado conectado para recibir ordenes "+socket.getPort());
                BossConection serverConection = new BossConection(socket,socket.getPort());
                System.out.println("Empleado en el puerto "+serverConection.getPort()+" Recibiendo mensajes");
            }
        }catch (Exception e){
            System.out.println(e);
            try {
                serverSocket.close();
            }catch (Exception ex2){
                System.out.println(ex2);
            }

        }
    }
}
