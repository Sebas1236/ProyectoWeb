/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

/**
 *
 * @author Sebastián
 */
public class CandidatoEspecialidad {
    private int idCandidatoCan;
    private int idEspecialidadCan;
    private int tiempoExpCan;

    public int getIdCandidatoCan() {
        return idCandidatoCan;
    }

    public void setIdCandidatoCan(int idCandidatoCan) {
        this.idCandidatoCan = idCandidatoCan;
    }

    public int getIdEspecialidadCan() {
        return idEspecialidadCan;
    }

    public void setIdEspecialidadCan(int idEspecialidadCan) {
        this.idEspecialidadCan = idEspecialidadCan;
    }

    public int getTiempoExpCan() {
        return tiempoExpCan;
    }

    public void setTiempoExpCan(int tiempoExpCan) {
        this.tiempoExpCan = tiempoExpCan;
    }
    
}
