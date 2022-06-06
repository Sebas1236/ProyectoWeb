/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Candidato;

/**
 *
 * @author Sebastián
 */
public class CandidatoDTO implements Serializable{
    private Candidato entidad;
    public CandidatoDTO()
    {
        this.entidad = new Candidato();
    }

    public Candidato getEntidad() {
        return entidad;
    }

    public void setEntidad(Candidato entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidatoDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
