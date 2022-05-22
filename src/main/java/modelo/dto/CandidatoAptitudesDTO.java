/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.CandidatoAptitudes;

/**
 *
 * @author Sebastián
 */
public class CandidatoAptitudesDTO implements Serializable{
    private CandidatoAptitudes entidad;
    public CandidatoAptitudesDTO()
    {
        this.entidad = new CandidatoAptitudes();
    }

    public CandidatoAptitudes getEntidad() {
        return entidad;
    }

    public void setEntidad(CandidatoAptitudes entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidatoAptitudesDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
