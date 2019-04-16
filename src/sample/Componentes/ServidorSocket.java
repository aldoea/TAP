package sample.Componentes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    private ServerSocket servidor;
    private Socket socketServidor;
    int noCte= 0;

    public ServidorSocket() {CrearServer();}

    private void CrearServer() {
        try{
            servidor = new ServerSocket(5000);
            do {
                System.out.println("Servidor en espera.....");
                socketServidor = servidor.accept();
                noCte++;
                System.out.println("Llega el cliente" + noCte);
                PrintStream salida = new PrintStream(socketServidor.getOutputStream());
                salida.println("Bienvenido ... XDXD");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(
                        socketServidor.getInputStream()
                ));
                System.out.println("El cliente dice: " + entrada.readLine());

                socketServidor.close();
            }while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
