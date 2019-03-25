package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Modelos.CategoriaDAO;
import sample.Modelos.PeliculaDAO;

public class Pelicula extends Stage {
    private TableView<PeliculaDAO> tbvPeliculas;
    private Scene escena;
    private VBox vBox;
    private Label lblTitulo;
    private TextField
        txtNomPeli,
        txtDuraPeli,
        txtDescPeli,
        txtClasePeli;
    private ComboBox<CategoriaDAO> cbCate;
    private Button btnGuardar;
    private PeliculaDAO objPDAO = null;

    public Pelicula(TableView<PeliculaDAO> tbvPelicula){
        tbvPeliculas = tbvPelicula;
        CrearGUI();
        this.setScene(escena);
        this.setTitle("Altas y modificaciones de peliculas");
        this.show();
    }

    public void CrearGUI() {
        vBox = new VBox();
        lblTitulo = new Label("Pelicula");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarPelicual());
        txtNomPeli = new TextField();
        txtNomPeli.setPromptText("Introduce el nombre");
        txtDuraPeli = new TextField();
        txtDuraPeli.setPromptText("Introduce la duración");
        txtDescPeli = new TextField();
        txtDescPeli.setPromptText("Aquí va la sinopsis");
        txtClasePeli = new TextField();
        txtClasePeli.setPromptText("Indica la clase");
        cbCate = new ComboBox<CategoriaDAO>(new CategoriaDAO().seleccionar());

        vBox.getChildren().addAll(lblTitulo,txtNomPeli,txtDuraPeli,txtDescPeli,txtClasePeli, cbCate, btnGuardar);
        escena = new Scene(vBox, 250, 300);
    }

    public void GuardarPelicual() {
        String nomb = txtNomPeli.getText();
        int dura = Integer.parseInt(txtDuraPeli.getText()) ;
        String sino = txtDescPeli.getText();
        String clas = txtClasePeli.getText();
        int cate = cbCate.getSelectionModel().getSelectedIndex() + 1;

        if(objPDAO == null) {
            objPDAO = new PeliculaDAO();
            objPDAO.setNomPelicula(nomb);
            objPDAO.setDuracion(dura);
            objPDAO.setDescPelicula(sino);
            objPDAO.setClase(clas);
            objPDAO.setIdCategoria(cate);
            objPDAO.insertar();
        }else {
            objPDAO.setNomPelicula(nomb);
            objPDAO.setDuracion(dura);
            objPDAO.setDescPelicula(sino);
            objPDAO.setClase(clas);
            objPDAO.setIdCategoria(cate);
            objPDAO.actualizar();
        }
        tbvPeliculas.setItems(objPDAO.seleccionar());
        tbvPeliculas.refresh();
        this.close();
    }

    public void setPeliculaDAO(PeliculaDAO objPDAO) {
        this.objPDAO = objPDAO;
        txtNomPeli.setText(objPDAO.getNomPelicula());
        txtDuraPeli.setText(String.valueOf(objPDAO.getDuracion()));
        txtDescPeli.setText(objPDAO.getDescPelicula());
        txtClasePeli.setText(objPDAO.getClase());
        cbCate.getSelectionModel().select(objPDAO.getIdCategoria()-1);
    }

}
