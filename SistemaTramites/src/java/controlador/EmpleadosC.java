package controlador;

import dao.EmpleadosD;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.EmpleadosM;

@Named(value = "EmpleadosC")
@SessionScoped
public class EmpleadosC implements Serializable {

    EmpleadosM empleados = new EmpleadosM();
    EmpleadosD dao = new EmpleadosD();
    private String user, pssw;
    private List<EmpleadosM> lstEmpleados;

    @PostConstruct
    public void inicio() {
        try {
            clearEmpleados();
            listEmpleados();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadosC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEmpleados() throws Exception {
        try {
            dao.addEmpleados(empleados);
            listEmpleados();
            clearEmpleados();
        } catch (Exception e) {
            throw e;
        }
    }

    public void clearEmpleados() throws Exception {
        try {
            empleados.setDniEmp(null);
            empleados.setNomEmp(null);
            empleados.setApeEmp(null);
            empleados.setEmailEmp(null);
            empleados.setCelEmp(null);
            empleados.setDirecEmp(null);
            empleados.setUserEmp(null);
            empleados.setPssEmp(null);
            empleados.setLevelEmp(null);
            empleados.setCodUbig(0);
            empleados.setCodA(0);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listEmpleados() throws Exception {
        try {
            lstEmpleados = dao.listarEmpleados();
        } catch (Exception e) {
            throw e;
        }
    }

    public EmpleadosM getEmpleados() {
        return empleados;
    }

    public void setEmpleados(EmpleadosM empleados) {
        this.empleados = empleados;
    }

    public EmpleadosD getDao() {
        return dao;
    }

    public void setDao(EmpleadosD dao) {
        this.dao = dao;
    }

    public List<EmpleadosM> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(List<EmpleadosM> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
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
