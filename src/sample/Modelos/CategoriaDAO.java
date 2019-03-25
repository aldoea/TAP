package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class CategoriaDAO {
    private int idCategoria;
    private String nomCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public ObservableList<CategoriaDAO> seleccionar() {
        String query = "SELECT * FROM tblcategoria ORDER BY idCategoria ASC ";
        ObservableList<CategoriaDAO> lista = FXCollections.observableArrayList();
        CategoriaDAO objCate = null;
        try{
            Statement stmt = Conexion.conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objCate = new CategoriaDAO();
                objCate.idCategoria = res.getInt("idCategoria");
                objCate.nomCategoria = res.getString("nomCategoria");
                lista.add(objCate);
            }
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
        return lista;
    }

    @Override
    public String toString() {
        return this.nomCategoria;
    }
}
