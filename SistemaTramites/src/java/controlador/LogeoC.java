package controlador;

import dao.LogeoD;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.LogeoM;

@Named(value = "LogeoC")
@SessionScoped

public class LogeoC implements Serializable{

    LogeoD dao = new LogeoD();
    LogeoM logeo = new LogeoM();
    private String user, pssw;
    
    public String ingresar() {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            dao = new LogeoD();
            logeo = dao.login(user);
            if (logeo == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El Usuario no existe"));
                return null;
            }
            if (logeo.getPssEmp().equals(pssw)) {
                switch (logeo.getLevelEmp()) {
                    case "ADMINISTRADOR":
                        contex.getExternalContext().redirect("/SistemaTramites/faces/vistas/tablas/Tramites.xhtml");
                    case "USUARIO":
                        contex.getExternalContext().redirect("/SistemaTramites/faces/vistas/tablas/Tramites.xhtml");
                    default:
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
                        return null;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña incorrecta"));
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña incorrecta"));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.valueOf(e)));
            return null;
        }
    }

    public LogeoD getDao() {
        return dao;
    }

    public void setDao(LogeoD dao) {
        this.dao = dao;
    }

    public LogeoM getLogeo() {
        return logeo;
    }

    public void setLogeo(LogeoM logeo) {
        this.logeo = logeo;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPssw() {
        return pssw;
    }

    public void setPssw(String pssw) {
        this.pssw = pssw;
    }
    
    

}
