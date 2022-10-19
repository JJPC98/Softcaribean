package entrega.data.data.bd;

import java.sql.SQLException;

public class ManagerConexion {

    private static ManagerConexion instance;
    private Conexion conexion;

    public ManagerConexion() {
        conexion = new Conexion();
    }

    public static ManagerConexion getInstance(){
        if(instance == null){
            instance = new ManagerConexion();
            return instance;
        }
        return instance;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void close() {
        try {
            conexion.getConection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            conexion.getConection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            conexion.getConection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reconectar(){
        conexion = new Conexion();
    }
}
