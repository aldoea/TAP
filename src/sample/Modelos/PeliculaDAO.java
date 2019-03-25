package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class PeliculaDAO {
    private int idPelicula;
    private String nomPelicula;
    private int duracion;
    private String descPelicula;
    private String clase;
    private int idCategoria;

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNomPelicula() {
        return nomPelicula;
    }

    public void setNomPelicula(String nomPelicula) {
        this.nomPelicula = nomPelicula;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescPelicula() {
        return descPelicula;
    }

    public void setDescPelicula(String descPelicula) {
        this.descPelicula = descPelicula;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void actualizar() {
        String query = "UPDATE tblpelicula SET " +
                    "nomPelicula = '"+nomPelicula+"', " +
                    "duracion = "+duracion+"," +
                    "descPelicula = '"+descPelicula+"'," +
                    "clase='"+clase+"'," +
                    "idCategoria="+idCategoria+" " +
                "WHERE" +
                    " idpelicula = "+idPelicula;
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }

    public void eliminar() {
        String query = "DELETE FROM tblpelicula WHERE idPelicula=" + idPelicula;
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }

    public ObservableList<PeliculaDAO> seleccionar() {
        ObservableList<PeliculaDAO> lista = FXCollections.observableArrayList();
        PeliculaDAO objPDAO = null;
        String query = "SELECT * FROM tblpelicula ORDER BY nomPelicula";
        try{
            Statement stmt = Conexion.conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objPDAO = new PeliculaDAO();
                objPDAO.idPelicula = res.getInt("idPelicula");
                objPDAO.nomPelicula = res.getString("nomPelicula");
                objPDAO.duracion = res.getInt("duracion");
                objPDAO.descPelicula = res.getString("descPelicula");
                objPDAO.clase = res.getString("clase");
                objPDAO.idCategoria = res.getInt("idCategoria");
                lista.add(objPDAO);
            }
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
        return lista;
    }

    public void insertar() {
        String query = "INSERT INTO tblpelicula(" +
                "nomPelicula," +
                "duracion," +
                "descPelicula," +
                "clase," +
                "idCategoria)" +
            " values(" +
                "'" + nomPelicula + "'," +
                duracion + "," +
                "'" + descPelicula + "', " +
                "'" + clase + "', " +
                idCategoria + ")";
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e);
        }
    }
}
