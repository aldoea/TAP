package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EventosCalculadora implements EventHandler {
    String valor;
    TextField txtOperacion;
    static int valorAnterior;
    static int ultimoValor;
    static int resultado;
    static boolean operacionFlag = false;

    public EventosCalculadora(String valor, TextField textOp) {
        this.valor = valor;
        txtOperacion = textOp;
    }

    @Override
    public void handle(Event event) {
        if(txtOperacion.getText().equals("0")) {
            txtOperacion.setText("");
        }
        switch (valor) {
            default:
                if(operacionFlag){
                    txtOperacion.setText("");
                    operacionFlag = false;
                    ultimoValor = 0;
                }
                txtOperacion.appendText(valor);
                break;
            case "+":
                valorAnterior = Integer.parseInt(txtOperacion.getText());
                operacionFlag = true;
                break;
            case "-":
                break;
            case "/":
                break;
            case "*":
                break;
            case "=":
                if(ultimoValor == 0) { // Para asegurar que se opere el ultimo valor si no se realiza una operación nueva.
                    ultimoValor = Integer.parseInt(txtOperacion.getText());
                    System.out.println("setting last value " + ultimoValor);
                }
                resultado = valorAnterior + ultimoValor;
                System.out.println("Valor anterior " + valorAnterior + " + " + ultimoValor + " = " + resultado);
                txtOperacion.setText(Integer.toString(resultado));
                valorAnterior = resultado;
                break;
            case ".":
                break;
        } // END switch
    } // END handle
} // END EventosCalculadora class
