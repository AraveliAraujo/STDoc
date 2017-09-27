package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadosM;
public class EmpleadosD extends Dao {

    static EmpleadosM employe = new EmpleadosM();
    
    public void addEmpleados(EmpleadosM empleados) throws Exception {
        try {
            this.Conectar();
            String sql = "EXECUTE insertEmpleado ?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, empleados.getDniEmp());
            ps.setString(2, empleados.getNomEmp());
            ps.setString(3, empleados.getApeEmp());
            ps.setString(4, empleados.getEmailEmp());
            ps.setString(5, empleados.getCelEmp());
            ps.setString(6, empleados.getDirecEmp());
            ps.setString(7, empleados.getUserEmp());
            ps.setString(8, empleados.getPssEmp());
            ps.setString(9, empleados.getLevelEmp());
            ps.setInt(10, empleados.getCodUbig());
            ps.setInt(11, empleados.getCodA());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public EmpleadosM login(String Empleados) throws Exception{
        this.Conectar();
        try {
            ResultSet rs;
            String sql = "Exec SP_UsuarioEmpl ?"; 
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Empleados);
            rs = ps.executeQuery();
            rs.next();
            employe.setDniEmp(rs.getString("DniEmp"));
            employe.setPssEmp(rs.getString("PssEmp"));
            employe.setLevelEmp(rs.getString("LevelEmp"));
            employe.setIdentidad(rs.getString("identidad"));
            employe.setCodEmp(rs.getInt("CodEmp"));
            switch (employe.getLevelEmp()){
                case "ADMINISTRADOR":
                    employe.setTemplate("TemplateAdmin.xhtml");
                    break;
                case "USUARIO":
                employe.setTemplate("TemplateUser.xhtml");
            }
            return employe;
        } catch (SQLException e) {
            return employe;
        }
    }
  
    public List<EmpleadosM> listarEmpleados() throws Exception {
        List<EmpleadosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM EMPLEADOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            EmpleadosM emp;
            while (rs.next()) {
                emp = new EmpleadosM();
                emp.setCodEmp(rs.getInt("CodEmp"));
                emp.setDniEmp(rs.getString("DniEmp"));
                emp.setNomEmp(rs.getString("NomEmp"));
                emp.setApeEmp(rs.getString("ApeEmp"));
                emp.setEmailEmp(rs.getString("EmailEmp"));
                emp.setCelEmp(rs.getString("CelEmp"));
                emp.setDirecEmp(rs.getString("DirecEmp"));
                emp.setUserEmp(rs.getString("UserEmp"));
                emp.setPssEmp(rs.getString("PssEmp"));
                emp.setLevelEmp(rs.getString("LevelEmp"));
                emp.setCodUbig(rs.getInt("CodUbig"));
                emp.setCodA(rs.getInt("CodA"));
                lista.add(emp);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
