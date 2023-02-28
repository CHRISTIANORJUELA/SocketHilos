package com.example.sockets_hilos.utils;

public enum MessageBar {
  ERROR("Error"),
  HUBOUNPROBLEMAECERRARLACOMUNICACION("Hubo un problema en cerrar la comunicación"),
  HUBOUNPROBLEMAENMANDARLAINFORMACION("Hubo un problema en mandar la informacion"),

  HUBOUNPROBLEMAENCONECTARCONELSERVIDOR("Hubo un problema en conectar con el servidor"),

  HUBOUNPROBLEMAENRECIBIRLOSDATOS("Hubo un problema en recibir los datos"),
  ERRORENCERRARELSERVIDOR("Hubo un problema en cerrar el servidor");

  private String mensaje;

  private MessageBar(String mensaje){
      this.mensaje = mensaje;
  }

    public String getMensaje() {
        return mensaje;
    }
}
