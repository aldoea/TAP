package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EventosCalculadora implements EventHandler {
    String valor;
    TextField txtOperacion;
    static String operacionSimbol;
    static double valorAnterior, ultimoValor, resultado;
    static boolean operacionFlag = false;
    static boolean soloDecimalFlag = false;

    public EventosCalculadora(String valor, TextField textOp) {
        this.valor = valor;
        txtOperacion = textOp;
    }

    @Override
    public void handle(Event event) {
        switch (valor) {
            default:
                if(txtOperacion.getText().equals("0")) {
                    txtOperacion.setText("");
                }
                if(operacionFlag && !soloDecimalFlag){
                    txtOperacion.setText("");
                    operacionFlag = false;
                    ultimoValor = 0;
                }
                txtOperacion.appendText(valor);
                break;
            case "+":
                valorAnterior = Double.parseDouble(txtOperacion.getText());
                operacionSimbol = valor;
                soloDecimalFlag = false;
                operacionFlag = true;
                break;
            case "-":
                valorAnterior = Double.parseDouble(txtOperacion.getText());
                operacionSimbol = valor;
                soloDecimalFlag = false;
                operacionFlag = true;
                break;
            case "/":
                valorAnterior = Double.parseDouble(txtOperacion.getText());
                operacionSimbol = valor;
                soloDecimalFlag = false;
                operacionFlag = true;
                break;
            case "*":
                valorAnterior = Double.parseDouble(txtOperacion.getText());
                operacionSimbol = valor;
                soloDecimalFlag = false;
                operacionFlag = true;
                break;
            case "=":
                if(ultimoValor == 0) { // Para asegurar que se opere el ultimo valor si no se realiza una operación nueva.
                    ultimoValor = Double.parseDouble(txtOperacion.getText());
                }
                hacerOperacion();
                if(resultado == 0) {
                    txtOperacion.setText("0");
                }else if(Double.isNaN(resultado)){
                    txtOperacion.setText("ERROR: Loop");
                }else{
                    txtOperacion.setText(Double.toString(resultado));
                }
                valorAnterior = resultado;
                break;
            case ".":
                if(txtOperacion.getText().equals("0") || (operacionFlag && !soloDecimalFlag) ) {
                    soloDecimalFlag = true;
                    ultimoValor = 0;
                    txtOperacion.setText("0.");
                }else{
                    // Prevenir que se agregue otro punto.
                    if(!soloDecimalFlag) txtOperacion.appendText(valor);
                }
                break;
            case "Ç":
                ultimoValor = 0;
                valorAnterior = 0;
                resultado = 0;
                operacionFlag = false;
                soloDecimalFlag = false;
                operacionSimbol = null;
                txtOperacion.setText("0");
        } // END switch
    } // END handle

    public void hacerOperacion() {
        switch (operacionSimbol){
            case "+":
                System.out.println("Valor anterior " + valorAnterior + " + " + ultimoValor + " = " + (valorAnterior + ultimoValor));
                resultado = valorAnterior + ultimoValor;
                break;
            case "-":
                System.out.println("Valor anterior " + valorAnterior + " - " + ultimoValor + " = " + (valorAnterior - ultimoValor));
                resultado = valorAnterior - ultimoValor;
                break;
            case "*":
                System.out.println("Valor anterior " + valorAnterior + " * " + ultimoValor + " = " + (valorAnterior * ultimoValor));
                resultado = valorAnterior * ultimoValor;
                break;
            case "/":
                System.out.println("Valor anterior " + valorAnterior + " /" + ultimoValor + " = " + (valorAnterior /  ultimoValor));
                resultado = valorAnterior / ultimoValor;
                break;
        }
    } //
} // END EventosCalculadora class
