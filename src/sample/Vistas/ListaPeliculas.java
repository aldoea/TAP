package sample.Vistas;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.ButtonCell;
import sample.Modelos.PeliculaDAO;

public class ListaPeliculas extends Stage {
    private Scene escena;
    private VBox vBox;
    private TableView<PeliculaDAO> tbvPelicula;
    private Button btnAgregar;

    public ListaPeliculas() {
        CrearGUI();
        setTitle("CRUD Peliculas");
        setScene(escena);
        show();
    }

    private void CrearGUI() {
        vBox = new VBox();
        tbvPelicula = new TableView<>();
        CrearTabla();
        btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(event -> AgregarPelicula());
        vBox.getChildren().addAll(tbvPelicula, btnAgregar);
        escena = new Scene(vBox, 1000, 500);
    }

    private void AgregarPelicula() {
        new Pelicula(tbvPelicula);
    }

    private void CrearTabla() {
        // 1- Crear columna
        //       <tipo de objecto, tipo de dato>                       "Nombre de encabezado"
        TableColumn<PeliculaDAO, Integer> tbcIdPelicula = new TableColumn<>("ID");
        tbcIdPelicula.setCellValueFactory(new PropertyValueFactory<>("idPelicula"));

        TableColumn<PeliculaDAO, String> tbcNomPelicula = new TableColumn<>("Pelicula");
        tbcNomPelicula.setCellValueFactory(new PropertyValueFactory<>("nomPelicula"));

        TableColumn<PeliculaDAO, Integer> tbcDuracion= new TableColumn<>("Duracion");
        tbcDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        TableColumn<PeliculaDAO, String> tbcClase = new TableColumn<>("Clase");
        tbcClase.setCellValueFactory(new PropertyValueFactory<>("clase"));

        TableColumn<PeliculaDAO, Integer> tbcDescPelicula = new TableColumn<>("Descripcion");
        tbcDescPelicula.setCellValueFactory(new PropertyValueFactory<>("descPelicula"));

        TableColumn<PeliculaDAO, Integer> tbcIdCategoria = new TableColumn<>("Categoria");
        tbcIdCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));

        TableColumn<PeliculaDAO, String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<PeliculaDAO, String>, TableCell<PeliculaDAO, String>>() {
            @Override
            public TableCell<PeliculaDAO, String> call(TableColumn<PeliculaDAO, String> peliculaDAOStringTableColumn) {
                return new ButtonCell(1);
            }
        });

        TableColumn<PeliculaDAO,String> tbcEliminar = new TableColumn<>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<PeliculaDAO, String>, TableCell<PeliculaDAO, String>>() {
            @Override
            public TableCell<PeliculaDAO, String> call(TableColumn<PeliculaDAO, String> param) {
                return new ButtonCell(2);
            }
        });

        tbvPelicula.getColumns().addAll(tbcIdPelicula, tbcNomPelicula, tbcDuracion, tbcClase, tbcDescPelicula, tbcIdCategoria, tbcEditar, tbcEliminar);
        tbvPelicula.setItems(new PeliculaDAO().seleccionar());
    }
}
