package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RestauranteMenu extends Stage {

    private Scene escena;
    private TabPane tabPane;
    private String[] tabsNames = {
        "Entradas", "Pastas", "Carnes", "Bebidas"
    };
    private VBox vBoxMain;
    private ArrayList<HBox> platillos = new ArrayList<>(tabsNames.length);
    private HBox[] hBoxContPlati = new HBox[tabsNames.length];
    private Button btnConfirmar;

    public RestauranteMenu() {
        CrearGUI();
        escena = new Scene(vBoxMain,400, 400);
        setTitle("Ratatouille");
        setScene(escena);
        setMaximized(true);
        show();
    }

    private Color[] colors = {
            Color.LIGHTSTEELBLUE,
            Color.LAWNGREEN,
            Color.TOMATO,
            Color.SLATEBLUE,
            Color.AQUA
    };

    private void CrearGUI() {
        vBoxMain = new VBox();
        vBoxMain.getStylesheets().add(getClass().getResource("../CSS/Bootstrap3.css").toExternalForm());
        vBoxMain.getStylesheets().add(getClass().getResource("../CSS/restaurant.css").toExternalForm());
        btnConfirmar = new Button("Confirmar");
        tabPane = new TabPane();
        for(int index = 0;index < tabsNames.length; index++) {
            Tab newTab = new Tab();
            newTab.setText(tabsNames[index]);
            crearPlatillos(index);
            newTab.setContent(hBoxContPlati[index]);
            newTab.closableProperty().setValue(false);
            tabPane.getTabs().add(newTab);
        }
        vBoxMain.getChildren().addAll(new Label("Agregue los platillos"), tabPane, btnConfirmar);
    }

    private void crearPlatillos(int index) {
        hBoxContPlati[index] = new HBox();
        for (int i = 0; i < 5; i++) {
            Rectangle t = new Rectangle(200,300, colors[i]);
            t.setStyle("-fx-padding: 0px, 30px, 0px, 30px");
            hBoxContPlati[index].getChildren().add(t);
            hBoxContPlati[index].getStyleClass().add("test-class");
        }
        platillos.add(hBoxContPlati[index]);
    }
}
