package modelo.entidades;

import java.sql.Date;

public class Candidato {
    private int idCan;
    private String nombreCan;
    private Date fechaNacCan;
    private String curriculumCan;
    private int idOcupabilidadCan;
    private int idEntFed;
    private int idUsuarioCan;

    public int getIdCan() {
        return idCan;
    }

    public void setIdCan(int idCan) {
        this.idCan = idCan;
    }

    public String getNombreCan() {
        return nombreCan;
    }

    public void setNombreCan(String nombreCan) {
        this.nombreCan = nombreCan;
    }

    public Date getFechaNacCan() {
        return fechaNacCan;
    }

    public void setFechaNacCan(Date fechaNacCan) {
        this.fechaNacCan = fechaNacCan;
    }

    public String getCurriculumCan() {
        return curriculumCan;
    }

    public void setCurriculumCan(String curriculumCan) {
        this.curriculumCan = curriculumCan;
    }

    public int getIdOcupabilidadCan() {
        return idOcupabilidadCan;
    }

    public void setIdOcupabilidadCan(int idOcupabilidadCan) {
        this.idOcupabilidadCan = idOcupabilidadCan;
    }

    public int getIdEntFed() {
        return idEntFed;
    }

    public void setIdEntFed(int idEntFed) {
        this.idEntFed = idEntFed;
    }

    public int getIdUsuarioCan() {
        return idUsuarioCan;
    }

    public void setIdUsuarioCan(int idUsuarioCan) {
        this.idUsuarioCan = idUsuarioCan;
    }
    
}
