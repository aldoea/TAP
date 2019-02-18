package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EventosCalculadora implements EventHandler {
    String valor;
    TextField txtOperacion;
    static String operacionSimbol;
    static double valorAnterior, ultimoValor, resultado;
    static boolean operacionFlag, soloDecimalFlag, errorFlag;

    public EventosCalculadora(String valor, TextField textOp) {
        this.valor = valor;
        txtOperacion = textOp;
    }

    @Override
    public void handle(Event event) {
        if(errorFlag) limpiar();
        switch (valor) {
            default:
                if(txtOperacion.getText().equals("0")) {
                    txtOperacion.setText("");
                }
                if(operacionFlag && !soloDecimalFlag){
                    txtOperacion.setText("");
                    ultimoValor = 0;
                    operacionFlag = false;
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
                if(operacionSimbol != null) {
                    hacerOperacion();
                    valorAnterior = resultado;
                }else {
                    resultado = Double.parseDouble(txtOperacion.getText());
                }
                if(resultado == 0) {
                    txtOperacion.setText("0");
                }else if(Double.isNaN(resultado) || Double.isInfinite(resultado)){
                    errorFlag = true;
                    txtOperacion.setText("ERROR LOOP: " + resultado);
                }else{
                    txtOperacion.setText(Double.toString(resultado));
                }
                break;
            case ".":
                // Agregar un cero-punto en caso de que no se indique el cero antes.
                if(txtOperacion.getText().equals("0") || ((operacionSimbol != null) && operacionFlag)) {
                    soloDecimalFlag = true;
                    txtOperacion.setText("0.");
                    //ultimoValor = 0;
                }else if(!soloDecimalFlag){ // Prevenir que se agregue otro punto.
                    txtOperacion.appendText(valor);
                    soloDecimalFlag = true;
                }
                break;
            case "Ç":
                limpiar();
        } // END switch
    } // END handle

    public void hacerOperacion() {
        switch (operacionSimbol){
            case "+":
                resultado = valorAnterior + ultimoValor;
                break;
            case "-":
                resultado = valorAnterior - ultimoValor;
                break;
            case "*":
                resultado = valorAnterior * ultimoValor;
                break;
            case "/":
                resultado = valorAnterior / ultimoValor;
                break;
        }
        operacionFlag = true;
        soloDecimalFlag = false;
    } //

    public void limpiar() {
        ultimoValor = 0;
        valorAnterior = 0;
        resultado = 0;
        operacionFlag = false;
        soloDecimalFlag = false;
        errorFlag = false;
        operacionSimbol = null;
        txtOperacion.setText("0");
    }
} // END EventosCalculadora class
