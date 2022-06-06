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
public class Contacto {
    private int idCon;
    private String descripcionCon;
    private int tipoContacto;
    private int idCandidato;

    public int getIdCon() {
        return idCon;
    }

    public void setIdCon(int idCon) {
        this.idCon = idCon;
    }

    public String getDescripcionCon() {
        return descripcionCon;
    }

    public void setDescripcionCon(String descripcionCon) {
        this.descripcionCon = descripcionCon;
    }

    public int getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(int tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    
}
