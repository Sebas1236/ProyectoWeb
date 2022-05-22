/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.CandidatoActitudes;

/**
 *
 * @author Sebastián
 */
public class CandidatoActitudesDTO implements Serializable{
    private CandidatoActitudes entidad;
    public CandidatoActitudesDTO()
    {
        this.entidad = new CandidatoActitudes();
    }

    public CandidatoActitudes getEntidad() {
        return entidad;
    }

    public void setEntidad(CandidatoActitudes entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidatoActitudesDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
