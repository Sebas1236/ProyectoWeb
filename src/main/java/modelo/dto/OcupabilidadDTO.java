/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Ocupabilidad;

/**
 *
 * @author Sebastián
 */
public class OcupabilidadDTO implements Serializable{
    private Ocupabilidad entidad;
    public OcupabilidadDTO()
    {
        this.entidad = new Ocupabilidad();
    }

    public Ocupabilidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Ocupabilidad entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OcupabilidadDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
            
      
}
