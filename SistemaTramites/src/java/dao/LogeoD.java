package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LogeoM;

public class LogeoD extends Dao{

    LogeoM logeo = new LogeoM();
    
    public LogeoM login(String login) throws Exception{
        this.Conectar();
        try {
            ResultSet rs;
            String sql = "Exec SP_UsuarioEmpl ?"; 
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, login);
            rs = ps.executeQuery();
            rs.next();
            logeo.setDniEmp(rs.getString("DniEmp"));
            logeo.setPssEmp(rs.getString("PssEmp"));
            logeo.setLevelEmp(rs.getString("LevelEmp"));
            logeo.setIdentidad(rs.getString("identidad"));
            logeo.setCodEmp(rs.getInt("CodEmp"));
            switch (logeo.getLevelEmp()){
                case "ADMINISTRADOR":
                    logeo.setTemplate("TemplateAdmin.xhtml");
                    break;
                case "USUARIO":
                logeo.setTemplate("TemplateUser.xhtml");
            }
            return logeo;
        } catch (SQLException e) {
            return logeo;
        }
    }
}
