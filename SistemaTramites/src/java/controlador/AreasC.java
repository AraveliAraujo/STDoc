package controlador;

import dao.AreasD;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.AreasM;

@Named(value = "AreasC")
@SessionScoped
public class AreasC implements Serializable {

    AreasM areas = new AreasM();
    AreasD dao = new AreasD(); 
    private List<AreasM> lstAreas;
    
    @PostConstruct
    public void inicio(){
        try {
            listAreas();
        } catch (Exception ex) {
            Logger.getLogger(TramitesC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addAreas() throws Exception{
        try {
            dao.AddAreas(areas);
            listAreas();
            clearAreas();
        } catch (Exception e) {
            throw e;
        }
    }
    public void clearAreas() throws Exception{
        try {
            areas.setCodA(0);
            areas.setNomA(null);
            areas.setDiasA(0);
        } catch (Exception e) {
            throw e;
        }
    }

    
    public void listAreas() throws Exception{
        try {
            lstAreas = dao.listarAreas();
        } catch (Exception e) {
            throw e;
        }
    }

    public AreasM getAreas() {
        return areas;
    }

    public void setAreas(AreasM areas) {
        this.areas = areas;
    }

    public AreasD getDao() {
        return dao;
    }

    public void setDao(AreasD dao) {
        this.dao = dao;
    }

    public List<AreasM> getLstAreas() {
        return lstAreas;
    }

    public void setLstAreas(List<AreasM> lstAreas) {
        this.lstAreas = lstAreas;
    }
    
}