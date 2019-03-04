package sample.Modelos;

import java.sql.Statement;

public class PeliculaDAO {
    private int idPelicula;
    private String nomPelicula;
    private int duracion;
    private String descPelicula;
    private int clase;
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

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
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
                "nomPelicula='NuevoValor'," +
                "duracion=130," +
                "descPelicula='eejejejejejejejejejejejeje'" +
                "clase='CDMX'" +
                "idCategoria=2" +
            "WHERE idPelicula=1";
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }

    public void eliminar() {
        String query = "DELETE FROM tblpelicula WHERE idPelicula=1";
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }

    public void seleccionar() {
        String query = "SELECT FROM tblpelicula WHERE idPelicula=1";
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }

    public void insertar() {
        String query = "INSERT INTO tblpelicula(" +
                "nomPelicula," +
                "duracion," +
                "descPelicula" +
                "clase" +
                "idCategoria)" +
            " values(" +
                "'valor1'," +
                "120, " +
                "'Lorem ipsum dolor mentus apterus lepsem', " +
                "'AA', " +
                "1) ";
        try{
            Statement stmt = Conexion.conn.createStatement();
            stmt.execute(query);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }
}
