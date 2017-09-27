package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.UsuariosM;

public class UsuariosD extends Dao {

    public void addUsuarios(UsuariosM usuarios) throws Exception {
        try {
            this.Conectar();
            String sql = "EXECUTE insertUsuario ?,?,?,?,?,?,?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, usuarios.getDniUsu());
            ps.setString(2, usuarios.getNomUsu());
            ps.setString(3, usuarios.getApeUsu());
            ps.setString(4, usuarios.getEmailUsu());
            ps.setString(5, usuarios.getCelUsu());
            ps.setString(6, usuarios.getDirecUsu());
            ps.setInt(7, usuarios.getCodUbig());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<UsuariosM> listarUsuarios() throws Exception {
        List<UsuariosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM USUARIOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            UsuariosM usu;
            while (rs.next()) {
                usu = new UsuariosM();
                usu.setCodUsu(rs.getInt("CodUsu"));
                usu.setDniUsu(rs.getString("DniUsu"));
                usu.setNomUsu(rs.getString("NomUsu"));
                usu.setApeUsu(rs.getString("ApeUsu"));
                usu.setEmailUsu(rs.getString("EmailUsu"));
                usu.setCelUsu(rs.getString("CelUsu"));
                usu.setDirecUsu(rs.getString("DirecUsu"));
                usu.setCodUbig(rs.getInt("CodUbig"));
                lista.add(usu);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
}
