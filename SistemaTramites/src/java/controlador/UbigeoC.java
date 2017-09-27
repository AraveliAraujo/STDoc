 
package controlador;

import dao.UbigeoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.UbigeoM;

@Named(value = "ubigeoC")
@SessionScoped
public class UbigeoC implements Serializable {

    
    UbigeoM ubigeo = new UbigeoM();
    UbigeoD dao = new UbigeoD();
    private List<String> LstDpto;
    private List<String> LstProv;
    private List<UbigeoM> LstDist;
    
    private String Dpto;
    private String Prov;
    
    @PostConstruct
    public void inicio(){
        try {
            listDpto();
        } catch (Exception e) {
        }
    }
    
    public void listDpto() throws Exception{
        try {
            LstDpto = dao.listDpto();
        } catch (Exception e) {
        }
    }
    
    public void listProv() throws Exception{
        try {
            LstProv = dao.listProv(Dpto);
        } catch (Exception e) {
        }
    }
    
    public void listDist() throws Exception{
        try {
            LstDist = dao.listDist(Prov);
        } catch (Exception e) {
        }
    }

    public UbigeoM getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(UbigeoM ubigeo) {
        this.ubigeo = ubigeo;
    }

    public UbigeoD getDao() {
        return dao;
    }

    public void setDao(UbigeoD dao) {
        this.dao = dao;
    }

    public List<String> getLstDpto() {
        return LstDpto;
    }

    public void setLstDpto(List<String> LstDpto) {
        this.LstDpto = LstDpto;
    }

    public List<String> getLstProv() {
        return LstProv;
    }

    public void setLstProv(List<String> LstProv) {
        this.LstProv = LstProv;
    }

    public List<UbigeoM> getLstDist() {
        return LstDist;
    }

    public void setLstDist(List<UbigeoM> LstDist) {
        this.LstDist = LstDist;
    }

    public String getDpto() {
        return Dpto;
    }

    public void setDpto(String Dpto) {
        this.Dpto = Dpto;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String Prov) {
        this.Prov = Prov;
    }
    
}
