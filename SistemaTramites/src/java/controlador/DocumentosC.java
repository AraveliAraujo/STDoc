package controlador;

import dao.DocumentosD;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.DocumentosM;

@Named(value = "DocumentosC")
@SessionScoped

public class DocumentosC implements Serializable {

    DocumentosM documentos = new DocumentosM();
    DocumentosD dao = new DocumentosD();
    private List<DocumentosM> lstDocumentos;

    @PostConstruct
    public void inicio() {
        try {
            listarDocumentos();
        } catch (Exception ex) {
            Logger.getLogger(DocumentosC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addDocumentos() throws Exception {
        try {
            dao.addDocumentos(documentos);
            listarDocumentos();
            clearDocumentos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void clearDocumentos() throws Exception {
        try {
            documentos.setCodDocs(0);
            documentos.setTipoDocs(null);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarDocumentos() throws Exception {
        try {
            lstDocumentos = dao.listarDocumentos();
        } catch (Exception e) {
            throw e;
        }
    }

    public DocumentosM getDocumentos() {
        return documentos;
    }

    public void setDocumentos(DocumentosM documentos) {
        this.documentos = documentos;
    }

    public DocumentosD getDao() {
        return dao;
    }

    public void setDao(DocumentosD dao) {
        this.dao = dao;
    }

    public List<DocumentosM> getLstDocumentos() {
        return lstDocumentos;
    }

    public void setLstDocumentos(List<DocumentosM> lstDocumentos) {
        this.lstDocumentos = lstDocumentos;
    }

}
