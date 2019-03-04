package sample.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String host = "localhost";
    private String BD = "mexflix";
    private String user = "topicos";
    private String pass = "admin";
    public static Connection conn;

    public void crearConexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+BD, user, pass);
        }catch (Exception e) {
            System.err.println("An error happens" + e.toString());
        }
    }
}
