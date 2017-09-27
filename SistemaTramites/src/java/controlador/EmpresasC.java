package controlador;

import dao.EmpresasD;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.EmpresasM;

@Named(value = "EmpresasC")
@SessionScoped

public class EmpresasC implements Serializable{

    EmpresasM empresas = new EmpresasM();
    EmpresasD dao = new EmpresasD();
    private List<EmpresasM> lstEmpresas;
    
   @PostConstruct
   public void inicio(){
       try {
           listarEmpresas();
       } catch (Exception ex) {
           Logger.getLogger(EmpresasC.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void addEmpresas()throws Exception{
       try {
           dao.addEmpresas(empresas);
           listarEmpresas();
           clearEmpresas();
       } catch (Exception e) {
           throw e;
       }
   }
   
   public void clearEmpresas() throws Exception{
       try {
           empresas.setCodEmpre(0);
           empresas.setNomEmpre(null);
           empresas.setRucEmpre(null);
           empresas.setDirecEmpre(null);
           empresas.setTelEmpre(null);
           empresas.setCodUbig(0);
       } catch (Exception e) {
           throw e;
       }
   }
   
   public void listarEmpresas()throws Exception{
       try {
           lstEmpresas = dao.listarEmpresas();
       } catch (Exception e) {
           throw e;
       }
   }

    public EmpresasM getEmpresas() {
        return empresas;
    }

    public void setEmpresas(EmpresasM empresas) {
        this.empresas = empresas;
    }

    public EmpresasD getDao() {
        return dao;
    }

    public void setDao(EmpresasD dao) {
        this.dao = dao;
    }

    public List<EmpresasM> getLstEmpresas() {
        return lstEmpresas;
    }

    public void setLstEmpresas(List<EmpresasM> lstEmpresas) {
        this.lstEmpresas = lstEmpresas;
    }
   
   
}
