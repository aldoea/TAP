package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class PlatilloDAO {
    public int id_platillo;
    public String platillo;
    public String img_platillo;
    public int id_caegoria;

    public ObservableList<PlatilloDAO> seleccionar() {
        ObservableList<PlatilloDAO> listaPlatillos = FXCollections.observableArrayList();
        PlatilloDAO objPlatilloDAO = null;
        String query = "SELECT * FROM platillo ORDER BY id_categoria ASC, id_platillo ASC";
        try{
            Statement stmt = Conexion.conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objPlatilloDAO = new PlatilloDAO();
                objPlatilloDAO.id_platillo = res.getInt("id_platillo");
                objPlatilloDAO.platillo = res.getString("platillo");
                objPlatilloDAO.img_platillo = res.getString("img_platillo");
                objPlatilloDAO.id_caegoria = res.getInt("id_categoria");
                listaPlatillos.add(objPlatilloDAO);
            }
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
        return listaPlatillos;
    }
}
