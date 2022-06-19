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
public class EntidadFederativa {
    private int idEnt;
    private String nombreEnt;

    public EntidadFederativa(){}
    public EntidadFederativa(int idEnt, String nombreEnt)
    {
        this.idEnt = idEnt;
        this.nombreEnt = nombreEnt;
    }
    public int getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(int idEnt) {
        this.idEnt = idEnt;
    }

    public String getNombreEnt() {
        return nombreEnt;
    }

    public void setNombreEnt(String nombreEnt) {
        this.nombreEnt = nombreEnt;
    }
    
}
