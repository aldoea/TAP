package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Vistas.Calculadora;

public class Main extends Application {

    private Scene escena;
    private MenuBar menuBar;
    private Menu menCompetencia1, menCompetencia2;
    private MenuItem itmCalculadora;
    private BorderPane panel;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        panel = new BorderPane();
        CreateMenu();

        escena = new Scene(panel);
        primaryStage.setTitle("Prácticas Tópicos Avanzado de Programación");
        primaryStage.setScene(escena);
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public void CreateMenu() {
        menuBar = new MenuBar();

        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");

        itmCalculadora = new MenuItem("Calculadora");
        itmCalculadora.setOnAction(actionEvent -> EventoItem(1));
        menCompetencia1.getItems().addAll(itmCalculadora);

        menuBar.getMenus().addAll(menCompetencia1, menCompetencia2);
        panel.setTop(menuBar);
    }

    private void EventoItem(int opc) {
        switch (opc) {
            case 1:
                new Calculadora();
                break;
            case 2: // New practica2()
                break;
            default:
                break;
        }
    }

}
