package sample.Componentes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteSocket {
    private Socket socketCliente;
    private InetAddress direccion;
    private int puerto = 5000;

    byte[] ip = new byte[]{(byte)192, (byte)168, (byte)1, (byte)67};
    public ClienteSocket() { CrearSocketCliente(); }

    private void CrearSocketCliente() {
        try{
            direccion = InetAddress.getByAddress(ip);
            socketCliente = new Socket(direccion, puerto);

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream())
            );
            System.out.println(entrada.readLine());

            PrintStream salida = new PrintStream((socketCliente.getOutputStream()));
            salida.println("Hola Servidor!!!");
        }catch (Exception e) {

        }
    }
}
