package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.Vistas.CuadroMagico;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EventosCuadroMagico implements EventHandler {
    private int accion;
    private int byteSize = 4;
    private static int numeroCasillas;

    public EventosCuadroMagico(int accion) {
        this.accion = accion;
    }
    private static RandomAccessFile fichero;

    @Override
    public void handle(Event event) {
        switch(accion){
            case 1:
                try {
                    String input = CuadroMagico.tamañoTxt.getText(); // Obtiene el valor ingresado
                    if(validarTamañoInput(input)) { // Validacion de input
                        CuadroMagico.n = Integer.parseInt(input); // Asigna el valor N del tamaño del cuadro magico.
                        CuadroMagico.generarCuadroMagico(); // Generala interfax del cuadro
                        fichero = new RandomAccessFile("cuadroMagico.txt", "rw"); // Abre el fichero
                        fichero.setLength(CuadroMagico.n*byteSize); // Establece el tamaño del fichero
                        fichero.seek(0); // Posiciona el apuntador al inico del fichero
                        numeroCasillas = CuadroMagico.n * CuadroMagico.n; // Tamaño del cuadro magico NxN
                        for(int k = 0; k < numeroCasillas; k++) { // Rellena el fichero con valores 0 'N' veces
                            fichero.writeInt(0);
                        }
                        mostrarFichero(); // Muestra el estado del fichero.
                    }
                    break;
                }catch (IOException e) {

                }

            case 2:
                try {
                    int i = 0; // Fila
                    int j = CuadroMagico.n/2; // Columna
                    int contador = 1; // Contador
                    int indexCasilla = (CuadroMagico.n * i) + j; // Posicionador de indice de cuadro

                    // Escribe el primer valor
                    escribirEntero(indexCasilla, contador);

                    // Algoritmo para llenar el cuadro.
                    while (contador < numeroCasillas) {
                        if((i-1)>=0) {
                            if((j+1)<(CuadroMagico.n)) {
                                indexCasilla = (((i-1) * CuadroMagico.n) + (j+1));
                                if (obtenerEntero(indexCasilla) == 0) {
                                    i -= 1;
                                    j += 1;
                                    contador += 1;
                                    indexCasilla = (CuadroMagico.n * i) + j;
                                    escribirEntero(indexCasilla, contador);
                                }else {
                                    i += 1;
                                    contador += 1;
                                    indexCasilla = (CuadroMagico.n * i) + j;
                                    escribirEntero(indexCasilla, contador);
                                }
                            }else {
                                indexCasilla = ((i-1) * CuadroMagico.n);
                                if (obtenerEntero(indexCasilla) == 0) {
                                    i -= 1;
                                    j = 0;
                                    contador += 1;
                                    indexCasilla = (CuadroMagico.n * i) + j;
                                    escribirEntero(indexCasilla, contador);
                                } else {
                                    i += 1;
                                    contador += 1;
                                    indexCasilla = (CuadroMagico.n * i) + j;
                                    escribirEntero(indexCasilla, contador);
                                }
                            }
                        }else{
                            if (((j + 1) < (CuadroMagico.n))) {
                                indexCasilla = (((CuadroMagico.n - 1) * CuadroMagico.n) + (j+1));
                                if (obtenerEntero(indexCasilla) == 0) {
                                    i = CuadroMagico.n - 1;
                                    j += 1;
                                    contador += 1;
                                    indexCasilla = (CuadroMagico.n * i) + j;
                                    escribirEntero(indexCasilla, contador);
                                } else {
                                    i += 1;
                                    contador += 1;
                                    indexCasilla = (CuadroMagico.n * i) + j;
                                    escribirEntero(indexCasilla, contador);
                                }
                            } else {
                                i += 1;
                                contador += 1;
                                indexCasilla = (CuadroMagico.n * i) + j;
                                escribirEntero(indexCasilla, contador);
                            }
                        }
                    } // END while
                    mostrarFichero();
                    System.out.println("Finish");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public boolean validarTamañoInput(String input ) { // Valida que sea número y si es impar
        try {
            int temp = Integer.parseInt(input);
            if(temp > 17 || temp <= 0) return false;
            return temp % 2 != 0;
        }catch(Exception e) {
            return false;
        }
    }

    public int obtenerEntero(int bytePos) throws IOException { // Obtiene el valor entero del fichero en una posicion
        fichero.seek(bytePos*byteSize);
        return fichero.readInt();
    }

    public void escribirEntero(int bytePos, int valor) throws  IOException { // Escribe el valor entero en el fichero y en el cuadro
        CuadroMagico.casillas[bytePos].setText(Integer.toString(valor));
        fichero.seek(bytePos * byteSize);
        fichero.writeInt(valor);
    }

    public static void mostrarFichero() { // Muestra el fichero en enteros.
        System.out.println("Mostrando Fichero");
        int n;
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                n = fichero.readInt();  //se lee  un entero del fichero
                System.out.println(n);  //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
