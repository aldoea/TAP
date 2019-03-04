package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RestauranteMenu extends Stage {

    private Scene escena;
    private BorderPane mainBorderPane;
    private TabPane tabPane;
    //private Tab[] tabs;
    private String[] tabsNames = {
        "Desayunos", "Comidas", "Bebidas", "Ligth"
    };
    public RestauranteMenu() {
        CrearGUI();
        escena = new Scene(mainBorderPane,400, 400);
        setTitle("Menu La Cafe 3");
        setScene(escena);
        setMaximized(true);
        show();
    }

    private void CrearGUI() {
        mainBorderPane = new BorderPane();
        mainBorderPane.getStylesheets().add(getClass().getResource("../CSS/Bootstrap3.css").toExternalForm());
        tabPane = new TabPane();
        tabPane.setTabMinHeight(100);
        tabPane.setTabMinWidth(200);
        for(int index = 0;index < tabsNames.length; index++) {
            Tab newTab = new Tab();
            newTab.setText(tabsNames[index]);
            BorderPane dishesPane = new BorderPane();
            dishesPane.setCenter(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
            newTab.setContent(dishesPane);
            newTab.closableProperty().setValue(false);
            tabPane.getTabs().add(newTab);
        }
        mainBorderPane.setCenter(tabPane);
    }
}
