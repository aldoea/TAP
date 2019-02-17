package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Vistas.Calculadora;
import sample.Vistas.Taquimecanografo;

public class Main extends Application {

    private Scene escena;
    private MenuBar menuBar;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem itmCalculadora, itmTaquimecanografo, itmSalir;
    private BorderPane panel;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        panel = new BorderPane();
        CreateMenu();

        escena = new Scene(panel);
        escena.getStylesheets().add(getClass().getResource("CSS/estilos.css").toExternalForm());
        primaryStage.setTitle("Prácticas Tópicos Avanzado de Programación");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public void CreateMenu() {
        menuBar = new MenuBar();

        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        menSalir = new Menu("Salir");

        itmCalculadora = new MenuItem("Calculadora");
        itmCalculadora.setOnAction(actionEvent -> EventoItem(1));
        menCompetencia1.getItems().addAll(itmCalculadora);

        itmTaquimecanografo = new MenuItem("Taquimecanografo");
        itmTaquimecanografo.setOnAction(actionEvent -> EventoItem(2));
        menCompetencia2.getItems().addAll(itmTaquimecanografo);

        itmSalir = new MenuItem("Bye");
        itmSalir.setOnAction(actionEvent -> EventoItem(3));
        itmSalir.setAccelerator(KeyCombination.NO_MATCH.keyCombination("Ctrl+x"));
        menSalir.getItems().add(itmSalir);

        menuBar.getMenus().addAll(menCompetencia1, menCompetencia2, menSalir);
        panel.setTop(menuBar);
    }

    private void EventoItem(int opc) {
        switch (opc) {
            case 1:
                new Calculadora();
                break;
            case 2:
                new Taquimecanografo();
                break;
            case 3: // New practica2() o mejor para salir
                System.exit(0);
                break;
            default:
                break;
        }
    }

}
