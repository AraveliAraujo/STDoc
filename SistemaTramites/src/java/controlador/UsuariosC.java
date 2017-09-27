package controlador;

import dao.UsuariosD;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.UsuariosM;

@Named(value = "UsuariosC")
@SessionScoped
public class UsuariosC implements Serializable {

    UsuariosM usuarios = new UsuariosM();
    UsuariosD dao = new UsuariosD(); 
    private List<UsuariosM> lstUsuarios;
    private int menu = 0; 
    
    @PostConstruct
    public void inicio(){
        try {
            listUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(TramitesC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUsuarios() throws Exception{
        try {
            dao.addUsuarios(usuarios);
            listUsuarios();
            clearUsuarios();
        } catch (Exception e) {
            throw e;
        }
    }
    public void clearUsuarios() throws Exception{
        try {
            usuarios.setCodUsu(0);
            usuarios.setDniUsu(null);
            usuarios.setNomUsu(null);
            usuarios.setApeUsu(null);
            usuarios.setEmailUsu(null);
            usuarios.setCelUsu(null);
            usuarios.setDirecUsu(null);
            usuarios.setCodUbig(0);
        } catch (Exception e) {
            throw e;
        }
    }

    
    public void listUsuarios() throws Exception{
        try {
            lstUsuarios = dao.listarUsuarios();
        } catch (Exception e) {
            throw e;
        }
    }

    public UsuariosM getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosM usuarios) {
        this.usuarios = usuarios;
    }

    public UsuariosD getDao() {
        return dao;
    }

    public void setDao(UsuariosD dao) {
        this.dao = dao;
    }

    public List<UsuariosM> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<UsuariosM> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }
}