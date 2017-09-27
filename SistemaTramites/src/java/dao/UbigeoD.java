package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.UbigeoM;

public class UbigeoD extends Dao {

    public List<String> listDpto() throws Exception {
        List<String> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT DISTINCT Dpto FROM UBIGEO ";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("Dpto"));
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<String> listProv(String Dpto) throws Exception {
        List<String> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT DISTINCT Prov FROM UBIGEO WHERE Dpto like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Dpto);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("Prov"));
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<UbigeoM> listDist(String Prov) throws Exception {
        List<UbigeoM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT DISTINCT CodUbig , Dist FROM UBIGEO WHERE Prov like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Prov);
            rs = ps.executeQuery();
            lista = new ArrayList();
            UbigeoM prov;
            while (rs.next()) {
                prov = new UbigeoM();
                prov.setCodUbig(rs.getInt("CodUbig"));
                prov.setDist(rs.getString("Dist"));
                lista.add(prov);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
