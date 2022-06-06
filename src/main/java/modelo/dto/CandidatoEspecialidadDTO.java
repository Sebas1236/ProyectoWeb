/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.CandidatoEspecialidad;

/**
 *
 * @author Sebastián
 */
public class CandidatoEspecialidadDTO implements Serializable{
    private CandidatoEspecialidad entidad;
    public CandidatoEspecialidadDTO()
    {
        this.entidad = new CandidatoEspecialidad();
    }

    public CandidatoEspecialidad getEntidad() {
        return entidad;
    }

    public void setEntidad(CandidatoEspecialidad entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidatoEspecialidadDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
