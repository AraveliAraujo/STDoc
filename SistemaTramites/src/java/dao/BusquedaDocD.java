package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.BusquedaDocM;

public class BusquedaDocD extends Dao {

    public int buscar(BusquedaDocM bdoc) throws Exception {
        this.Conectar();
        int ingreso = 0;
        try {
            String sql = "exec buscar ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, bdoc.getDniUsu());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ingreso = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
        return ingreso;
    }
//    
//    public List<BusquedaDocM> listarDocumentos() throws Exception {
//        List<BusquedaDocM> lista;
//        ResultSet rs;
//        try {
//            this.Conectar();
//            String sql = "SELECT * FROM DOCUMENTOS";
//            PreparedStatement ps = this.getCn().prepareStatement(sql);
//            rs = ps.executeQuery();
//            lista = new ArrayList();
//            BusquedaDocM docs;
//            while (rs.next()) {
//                docs = new BusquedaDocM();
//                docs.setCodDocs(rs.getInt("CodDocs"));
//                docs.setTipoDocs(rs.getString("TipDocs"));
//                lista.add(docs);
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return lista;
//    }
}
