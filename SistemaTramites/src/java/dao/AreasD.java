package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.AreasM;

public class AreasD extends Dao {

    public void AddAreas(AreasM areas) throws Exception {
        try {
            this.Conectar();
            String sql = "EXEC insertArea ?,?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, areas.getNomA());
            ps.setInt(2, areas.getDiasA());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<AreasM> listarAreas() throws Exception {
        List<AreasM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM AREAS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            AreasM areas;
            while (rs.next()) {
                areas = new AreasM();
                areas.setCodA(rs.getInt("CodA"));
                areas.setNomA(rs.getString("NomA"));
                areas.setDiasA(rs.getInt("DiasA"));
                lista.add(areas);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
