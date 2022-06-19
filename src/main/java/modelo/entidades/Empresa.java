package modelo.entidades;
public class Empresa {
    private int idEmpresa;
    private String nombreEmp;
    private String logoEmp;
    private String esloganEmp;
    private String descripcionEmp;
    private int idUsuarioEmp;

    public Empresa(){}

    public Empresa(int idEmpresa, String nombreEmp, String logoEmp, String esloganEmp, String descripcionEmp, int idUsuarioEmp) {
        this.idEmpresa = idEmpresa;
        this.nombreEmp = nombreEmp;
        this.logoEmp = logoEmp;
        this.esloganEmp = esloganEmp;
        this.descripcionEmp = descripcionEmp;
        this.idUsuarioEmp = idUsuarioEmp;
    }
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getLogoEmp() {
        return logoEmp;
    }

    public void setLogoEmp(String logoEmp) {
        this.logoEmp = logoEmp;
    }

    public String getEsloganEmp() {
        return esloganEmp;
    }

    public void setEsloganEmp(String esloganEmp) {
        this.esloganEmp = esloganEmp;
    }

    public String getDescripcionEmp() {
        return descripcionEmp;
    }

    public void setDescripcionEmp(String descripcionEmp) {
        this.descripcionEmp = descripcionEmp;
    }

    public int getIdUsuarioEmp() {
        return idUsuarioEmp;
    }

    public void setIdUsuarioEmp(int idUsuarioEmp) {
        this.idUsuarioEmp = idUsuarioEmp;
    }
    
    
}
