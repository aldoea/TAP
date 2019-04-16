package sample.Vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Modelos.Conexion;
import sample.Modelos.PlatilloDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RestauranteMenu extends Stage implements EventHandler {

    private Scene escena;
    private TabPane tabPane;
    private String[] tabsNames = {
        "Entradas", "Pastas", "Carnes", "Bebidas"
    };
    private VBox vBoxMain;
    private ObservableList<PlatilloDAO> listaPlatillos = FXCollections.observableArrayList();
    private HBox[] hBoxContPlati = new HBox[tabsNames.length];
    private Button btnConfirmar;

    private int startBuilder = 0;


    public RestauranteMenu() {
        setConnection();
        listaPlatillos = new PlatilloDAO().seleccionar();
        CrearGUI();
        escena = new Scene(vBoxMain,400, 400);
        setTitle("Ratatouille");
        setScene(escena);
        setMaximized(true);
        this.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this);
        show();
    }

    private void CrearGUI() {
        vBoxMain = new VBox();
        vBoxMain.getStylesheets().add(getClass().getResource("../CSS/Bootstrap3.css").toExternalForm());
        vBoxMain.getStylesheets().add(getClass().getResource("../CSS/restaurant.css").toExternalForm());

        Label mainHeader = new Label("Agregue los platillos");
        mainHeader.setId("main-header-label");
        tabPane = new TabPane();
        btnConfirmar = new Button("Confirmar");
        btnConfirmar.setId("confirmar-orden-btn");

        HBox header = new HBox();
        HBox body = new HBox();
        HBox footer = new HBox();

        for(int index = 0;index < tabsNames.length; index++) {
            Tab newTab = new Tab();
            newTab.setText(tabsNames[index]);
            crearPlatillos(index);
            ScrollPane myscroll = new ScrollPane();
            myscroll.setFitToWidth(true);
            myscroll.setFitToHeight(true);
            myscroll.setContent(hBoxContPlati[index]); // SCROLLABLE !¡
            newTab.setContent(myscroll);
            newTab.closableProperty().setValue(false);
            tabPane.getTabs().add(newTab);
        }

        header.getChildren().add(mainHeader);
        body.getChildren().add(tabPane);
        footer.getChildren().add(btnConfirmar);

        header.getStyleClass().add("my-header");
        footer.getStyleClass().add("my-footer");
        btnConfirmar.getStyleClass().addAll("btn", "success", "lg");
        vBoxMain.getChildren().addAll(header, body, footer);
    }

    private void crearPlatillos(int index) {
        hBoxContPlati[index] = new HBox();
        for (int i = startBuilder; i < listaPlatillos.size(); i++) {
            if(index+1 == listaPlatillos.get(i).id_caegoria) {
                VBox platillo = new VBox();
                VBox platilloContainer = new VBox();

                HBox platilloImagen = new HBox();
                Label platilloTitulo = new Label(listaPlatillos.get(i).platillo);
                Button btnAgregarPlatillo = new Button("Agregar a orden");

                platillo.getStyleClass().add("vbox-platillo");
                platilloContainer.getStyleClass().add("platillo-container");
                platilloImagen.getStyleClass().add("platillo-imagen");
                platilloImagen.setStyle("-fx-background-image: url(" + listaPlatillos.get(i).img_platillo+  ")");
                platilloTitulo.getStyleClass().add("platillo-titulo");
                btnAgregarPlatillo.getStyleClass().addAll("button", "primary", "btn-anadir");

                platilloContainer.getChildren().addAll(platilloImagen, platilloTitulo, btnAgregarPlatillo);
                platillo.getChildren().add(platilloContainer);
                hBoxContPlati[index].getChildren().add(platillo);
                hBoxContPlati[index].getStyleClass().add("platillos");
            }else {
                startBuilder = i;
                break;
            }
        }
        //tabPane.getChildren.add(hBoxContPlati[index]);
    }

    @Override
    public void handle(Event event) {
        Conexion.cerrarConexion();
        System.out.println("Conexión cerrada exitosamente");
    }

    private void setConnection() {
        Conexion.crearConexion("restaurante");
        if(Conexion.conn != null) {
            System.out.println("Conexion exitosa a restaurante");
        }
    }
}
