package controlador;

import dao.TramitesD;
import dao.UsuariosD;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.TramitesM;
import modelo.UsuariosM;

@Named(value = "TramitesC")
@SessionScoped
public class TramitesC implements Serializable {

    TramitesM tramites = new TramitesM();
    TramitesD dao = new TramitesD();
    private List<TramitesM> lstTramites;

    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date(System.currentTimeMillis());

    @PostConstruct
    public void inicio() {
        try {
            listTramites();
            tramites.setFecIngreTram(date.format(now));
        } catch (Exception ex) {
            Logger.getLogger(TramitesC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTramites() throws Exception {
        try {
            dao.addTramites(tramites);
            listTramites();
            clearTramites();
        } catch (Exception e) {
            throw e;
        }
    }

    public void clearTramites() throws Exception {
        try {
            tramites.setCodTram(0);
            tramites.setEstadTram(null);
            tramites.setRptaTram(null);
            tramites.setObserTram(null);
            tramites.setFoliacion(null);
            tramites.setAsuntoTram(null);
            tramites.setCodUsu(0);
            tramites.setCodEmpre(0);
            tramites.setCodA(0);
            tramites.setCodDocs(0);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listTramites() throws Exception {
        try {
            lstTramites = dao.listarTramites();
        } catch (Exception e) {
            throw e;
        }
    }

    public TramitesM getTramites() {
        return tramites;
    }

    public void setTramites(TramitesM tramites) {
        this.tramites = tramites;
    }

    public TramitesD getDao() {
        return dao;
    }

    public void setDao(TramitesD dao) {
        this.dao = dao;
    }

    public List<TramitesM> getLstTramites() {
        return lstTramites;
    }

    public void setLstTramites(List<TramitesM> lstTramites) {
        this.lstTramites = lstTramites;
    }

}
