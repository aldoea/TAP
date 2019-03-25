package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import sample.Eventos.EventosCuadroMagico;

public class CuadroMagico extends Stage {
    private Scene escena;
    private static BorderPane mainBorderPane;
    // FORM
    public static TextField tamañoTxt;
    private Button generarBtn, rellenarBtn;
    private HBox formulario;
    // CUADRO MAGICO
    private static TilePane cuadroMagico;
    public static int n;
    public static TextArea[] casillas;
    private static int tamanoDeVentana = 1000;

    public CuadroMagico() {
        CrearGUI();
        escena = new Scene(mainBorderPane, tamanoDeVentana, tamanoDeVentana);
        setTitle("Cuadro Mágico");
        setScene(escena);
        show();
    }

    private void CrearGUI() {
        mainBorderPane = new BorderPane();
        mainBorderPane.getStylesheets().add(getClass().getResource("../CSS/cuadroMagico.css").toExternalForm());
        // GENERAR FORMULARIO
        tamañoTxt = new TextField();
        generarBtn = new Button("Generar");
        generarBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosCuadroMagico(1));
        rellenarBtn = new Button("Rellenar");
        rellenarBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventosCuadroMagico(2));
        formulario = new HBox();
        formulario.getChildren().addAll(tamañoTxt, generarBtn, rellenarBtn);
        mainBorderPane.setTop(formulario);
    }

    private static double calcularCasilla() { // Calcula el tamaño de las celdas del cuadro mágico
        double tamanoCasilla = (tamanoDeVentana - 200) / n;
        if(tamanoCasilla > 100) tamanoCasilla = 100;
        return tamanoCasilla;
    }

    public static void generarCuadroMagico() {
        // GENERAR CUADRO MAGICO
        double tamanoCasilla = calcularCasilla();
        cuadroMagico = new TilePane();
        cuadroMagico.setPrefColumns(n);
        cuadroMagico.setPrefRows(n);
        cuadroMagico.setMaxHeight(n*tamanoCasilla);
        cuadroMagico.setMaxWidth(n*tamanoCasilla);

        int nCasillas = n*n;
        casillas = new TextArea[nCasillas];
        for (int i = 0; i < nCasillas; i++) {
            casillas[i] = new TextArea();
            casillas[i].setMaxHeight(tamanoCasilla);
            casillas[i].setMaxWidth(tamanoCasilla);
            casillas[i].setEditable(false);
            casillas[i].setText("0");
            cuadroMagico.getChildren().add(casillas[i]);
        }
        mainBorderPane.setCenter(cuadroMagico);
    }
}
