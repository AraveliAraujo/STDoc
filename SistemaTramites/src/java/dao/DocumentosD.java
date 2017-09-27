package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.DocumentosM;

public class DocumentosD extends Dao {

    static DocumentosM employe = new DocumentosM();

    public void addDocumentos(DocumentosM documentos) throws Exception {
        try {
            this.Conectar();
            String sql = "EXECUTE insertDocumento ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, documentos.getTipoDocs());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<DocumentosM> listarDocumentos() throws Exception {
        List<DocumentosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM DOCUMENTOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            DocumentosM docs;
            while (rs.next()) {
                docs = new DocumentosM();
                docs.setCodDocs(rs.getInt("CodDocs"));
                docs.setTipoDocs(rs.getString("TipDocs"));
                lista.add(docs);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
