/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Especialidad;

/**
 *
 * @author Sebastián
 */
public class EspecialidadDTO implements Serializable{
    private Especialidad entidad;
    public EspecialidadDTO()
    {
        this.entidad = new Especialidad();
    }

    public Especialidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Especialidad entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EspecialidadDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
