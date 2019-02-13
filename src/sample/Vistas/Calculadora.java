package sample.Vistas;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Eventos.EventosCalculadora;

public class Calculadora extends Stage implements EventHandler {

    TextField txtOperacion;
    VBox vBox;
    HBox[] arHBox;
    Button[] arBtns;
    private String[] valores = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
    private Scene escena;

    public Calculadora(){
        CrearGUI();
        escena = new Scene(vBox, 200, 250);
        setScene(escena);
        setTitle("Calculadora");
        // Se implementa de esta manera porque arriba esta declarado el manejador general
        this.addEventHandler(WindowEvent.WINDOW_SHOWN, this);
        show();
    }

    private void CrearGUI(){
        vBox = new VBox();
        vBox.setSpacing(18);
        txtOperacion = new TextField();
        txtOperacion.setText("0");
        txtOperacion.setFocusTraversable(false);
        txtOperacion.setEditable(false);
        vBox.getChildren().add(txtOperacion);

        arHBox= new HBox[4];
        arBtns= new Button[16];

        int posBtn=0;
        for(int i=0; i<arHBox.length;i++){
            arHBox[i]= new HBox();
            arHBox[i].setSpacing(18);
            arHBox[i].setPadding(new Insets(5));
            for(int j=0; j<4; j++){
                arBtns[posBtn]= new Button(valores[posBtn]);
                arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventosCalculadora(valores[posBtn], txtOperacion));
                arBtns[posBtn].setStyle("-fx-font: 15 arial");
                arHBox[i].getChildren().add(arBtns[posBtn]);
                posBtn++;
            }
        }
        vBox.getChildren().addAll(arHBox[0],arHBox[1],arHBox[2],arHBox[3]);
    }

    @Override
    public void handle(Event event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Esta es una alerta informativa");
        alerta.setHeaderText("Este es el encabezado de la alerta");
        alerta.setContentText("Aqui va un buen chorizo");
        alerta.showAndWait();
    }
}