package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    Connection cn;

    public void Conectar() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.8.103:1433;databaseName=TRAMITEDOC;user=E01;password=Equipo01");
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
