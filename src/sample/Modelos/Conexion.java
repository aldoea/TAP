package sample.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String host = "localhost";
    //private static String BD = "mexflix";
    private static String user = "topicos";
    private static String pass = "admin";
    public static Connection conn;

    public static void crearConexion(String BD) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://"+host+"/"+BD, user, pass);
        }catch (Exception e) {
            System.err.println("An error happens " + e);
        }
    }

    public static void cerrarConexion() {
        try {
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
