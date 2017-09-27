package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.TramitesM;

public class TramitesD extends Dao {

    public void addTramites(TramitesM tramites) throws Exception {
        try {
            this.Conectar();
            String sql = "EXECUTE insertTramite ?,?,?,?,?,?,?,?,?,?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tramites.getFecIngreTram());
            ps.setString(2, "EN ESPERA");
            ps.setString(3, tramites.getRptaTram());
            ps.setString(4, tramites.getObserTram());
            ps.setString(5, tramites.getFoliacion());
            ps.setString(6, tramites.getAsuntoTram());
            ps.setInt(7, tramites.getCodUsu());
            ps.setInt(8, tramites.getCodEmpre());
            ps.setInt(9, tramites.getCodA());
            ps.setInt(10, tramites.getCodDocs());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<TramitesM> listarTramites() throws Exception {
        List<TramitesM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM TRAMITES";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            TramitesM tram;
            while (rs.next()) {
                tram = new TramitesM();
                tram.setCodTram(rs.getInt("CodTram"));
                tram.setFecIngreTram(rs.getString("FechTram"));
                tram.setEstadTram(rs.getString("EstadTram"));
                tram.setRptaTram(rs.getString("RptaTram"));
                tram.setObserTram(rs.getString("ObserTram"));
                tram.setFoliacion(rs.getString("Foliacion"));
                tram.setAsuntoTram(rs.getString("AsuntoTram"));
                tram.setCodUsu(rs.getInt("CodUsu"));
                tram.setCodEmpre(rs.getInt("CodEmpre"));
                tram.setCodA(rs.getInt("CodA"));
                tram.setCodDocs(rs.getInt("CodDocs"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
