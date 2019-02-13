package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Eventos.EventoTeclado;

public class Taquimecanografo extends Stage {

    private Scene escena;
    private VBox vbox;
    private ToolBar tlbMenu;
    private TextArea txtTexto, txtEscritura;

    public Taquimecanografo() {
        CrearGUI();
        escena = new Scene(vbox, 400, 600);
        setTitle("Tutor de Taquimecanografia");
        setScene(escena);
        show();
    }

    private void CrearGUI() {
        vbox = new VBox();
        tlbMenu = new ToolBar();
        txtTexto = new TextArea();
        txtTexto.setEditable(false);
        txtEscritura = new TextArea();
        txtEscritura.addEventHandler(KeyEvent.KEY_TYPED, new EventoTeclado());
        // Añadir el teclado.

        vbox.getChildren().addAll(tlbMenu, txtTexto, txtEscritura);
    }

}
