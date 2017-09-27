package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpresasM;

public class EmpresasD extends Dao {

    static EmpresasM empresa = new EmpresasM();

    public void addEmpresas(EmpresasM empresas) throws Exception {
        try {
            this.Conectar();
            String sql = "EXECUTE insertEmpresa ?,?,?,?,?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, empresas.getNomEmpre());
            ps.setString(2, empresas.getRucEmpre());
            ps.setString(3, empresas.getDirecEmpre());
            ps.setString(4, empresas.getTelEmpre());
            ps.setInt(5, empresas.getCodUbig());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<EmpresasM> listarEmpresas() throws Exception {
        List<EmpresasM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM EMPRESAS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            EmpresasM empre;
            while (rs.next()) {
                empre = new EmpresasM();
                empre.setCodEmpre(rs.getInt("CodEmpre"));
                empre.setNomEmpre(rs.getString("NomEmpre"));
                empre.setRucEmpre(rs.getString("RucEmpre"));
                empre.setDirecEmpre(rs.getString("DirecEmpre"));
                empre.setTelEmpre(rs.getString("TelEmpre"));
                empre.setCodUbig(rs.getInt("CodUbig"));
                lista.add(empre);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
