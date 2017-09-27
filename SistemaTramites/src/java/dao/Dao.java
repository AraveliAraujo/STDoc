package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    Connection cn;

    public static Connection ConectarReporte() throws ClassNotFoundException {
//        String url = "jdbc:sqlserver://192.168.2.40:1433;databaseName=Agricultura";
        String url = "jdbc:sqlserver://192.168.8.161:1433;databaseName=TRAMITEDOC";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection link = DriverManager.getConnection(url, "ivan", "ivansito");
            return link;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion " + e + "error de conexion ");
        }
        return null;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.2.40:1433;databaseName=Agricultura;user=sa;password=Equipo04");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TRAMITEDOC;user=user;password=user");
            if (cn != null) {
                System.out.println("Conectado");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) throws Exception {
        Dao dao = new Dao();
        dao.Conectar();
    }

}
