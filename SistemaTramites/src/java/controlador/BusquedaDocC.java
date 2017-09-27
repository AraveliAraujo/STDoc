package controlador;

import dao.BusquedaDocD;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.BusquedaDocM;

@ManagedBean
@SessionScoped
public class BusquedaDocC {

    private BusquedaDocM busMod = new BusquedaDocM();
    BusquedaDocD busDao = new BusquedaDocD();

    public void busqueda() throws Exception {
        try {
            int a = busDao.buscar(busMod);
            if (a != 0) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("vistas/documentos/DocsUserPorTramite.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No encontrado"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public BusquedaDocM getBusMod() {
        return busMod;
    }

    public void setBusMod(BusquedaDocM busMod) {
        this.busMod = busMod;
    }
    

}
