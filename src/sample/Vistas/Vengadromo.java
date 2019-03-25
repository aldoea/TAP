package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Componentes.Vengadores;

public class Vengadromo extends Stage {
    private ProgressBar[] pgbCarriles = new ProgressBar[7];
    private VBox vBox;
    private Button btnInit;
    private Scene escene;
    private String[] vengadores = {"Thor", "Capitan America", "Hulk", "Spider Man", "Black Panther", "Pantera Rosa"};
    private Vengadores[] thrVengadores = new Vengadores[7];

    public Vengadromo() {
        CrearGUI();
        setTitle("Vengadromo");
        setScene(escene);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        for (int i=0; i<vengadores.length; i++) {
            pgbCarriles[i] = new ProgressBar();
            //pgbCarriles[i];
            thrVengadores[i] = new Vengadores(vengadores[i]);
            vBox.getChildren().add(pgbCarriles[i]);
        }
        btnInit = new Button("Iniciar carrera");
        btnInit.setOnAction(event -> IniciarCarrera());
        vBox.getChildren().add(btnInit);
        escene = new Scene(vBox, 250, 300);
    }

    private void IniciarCarrera() {
        for (int i=0; i<vengadores.length; i++) {
            thrVengadores[i].start();
        }
    }
}
