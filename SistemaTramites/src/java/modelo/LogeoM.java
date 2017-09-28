package modelo;

public class LogeoM {

    private int CodEmp;
    private String DniEmp, Template = "Template.xhtml", identidad, UserEmp, PssEmp, LevelEmp;

    public String getDniEmp() {
        return DniEmp;
    }

    public void setDniEmp(String DniEmp) {
        this.DniEmp = DniEmp;
    }

    public String getTemplate() {
        return Template;
    }

    public void setTemplate(String Template) {
        this.Template = Template;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getUserEmp() {
        return UserEmp;
    }

    public void setUserEmp(String UserEmp) {
        this.UserEmp = UserEmp;
    }

    public String getPssEmp() {
        return PssEmp;
    }

    public void setPssEmp(String PssEmp) {
        this.PssEmp = PssEmp;
    }

    public String getLevelEmp() {
        return LevelEmp;
    }

    public void setLevelEmp(String LevelEmp) {
        this.LevelEmp = LevelEmp;
    }

    public int getCodEmp() {
        return CodEmp;
    }

    public void setCodEmp(int CodEmp) {
        this.CodEmp = CodEmp;
    }

    
}
