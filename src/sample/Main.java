package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Componentes.Vengadores;
import sample.Modelos.Conexion;
import sample.Vistas.*;

public class Main extends Application implements EventHandler {

    private Scene escena;
    private MenuBar menuBar;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem itmCalculadora, itmTaquimecanografo, itmRestauranteMenu, itmCuadroMagico, itmSalir, itmDatos, itmHilos;
    private BorderPane panel;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        panel = new BorderPane();
        CreateMenu();

        TitledPane objTP = new TitledPane();
        objTP.getStyleClass().add("danger");
        panel.setLeft(objTP);

        escena = new Scene(panel);
        escena.getStylesheets().add(getClass().getResource("CSS/Bootstrap3.css").toExternalForm());
        primaryStage.setTitle("Prácticas Tópicos Avanzado de Programación");
        primaryStage.setScene(escena);
        //primaryStage.setMaximized(true);
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN, this);
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

        itmCuadroMagico = new MenuItem("Cuadro Mágico");
        itmCuadroMagico.setOnAction(actionEvent -> EventoItem(5));
        menCompetencia1.getItems().add(itmCuadroMagico);

        itmDatos = new MenuItem("Acceso a datos (BD)");
        itmDatos.setOnAction(actionEvent -> EventoItem(6));
        menCompetencia1.getItems().add(itmDatos);

        itmRestauranteMenu = new MenuItem("Menú");
        itmRestauranteMenu.setOnAction(actionEvent -> EventoItem(4));
        menCompetencia1.getItems().add(itmRestauranteMenu);

        itmTaquimecanografo = new MenuItem("Taquimecanografo");
        itmTaquimecanografo.setOnAction(actionEvent -> EventoItem(2));
        menCompetencia2.getItems().add(itmTaquimecanografo);

        itmHilos = new MenuItem("Vengadromo");
        itmHilos.setOnAction(actionEvent -> EventoItem(7));
        menCompetencia2.getItems().add(itmHilos);


        itmSalir = new MenuItem("Bye");
        itmSalir.setOnAction(actionEvent -> EventoItem(0));
        itmSalir.setAccelerator(KeyCombination.NO_MATCH.keyCombination("Ctrl+x"));
        menSalir.getItems().add(itmSalir);

        menuBar.getMenus().addAll(menCompetencia1, menCompetencia2, menSalir);
        panel.setTop(menuBar);
    }

    private void EventoItem(int opc) {
        switch (opc) {
            case 0: // New practica2() o mejor para salir
                System.exit(0);
                break;
            case 1:
                new Calculadora();
                break;
                case 2:
            new Taquimecanografo();
                break;
            case 4:
                new RestauranteMenu();
                break;
            case 5:
                new CuadroMagico();
                break;
            case 6:
                new ListaPeliculas();
                break;
            case 7:
                new Vengadromo();
                break;
            default:
                break;
        }
    }

    @Override
    public void handle(Event event) {
        Conexion.crearConexion("mexflix");
        if(Conexion.conn != null) {
            System.out.println("Conexion exitosa");
        }
    }
}
