/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.EntidadFederativa;

/**
 *
 * @author Sebastián
 */
public class EntidadFederativaDTO implements Serializable{
    private EntidadFederativa entidad;
    public EntidadFederativaDTO()
    {
        this.entidad = new EntidadFederativa();
    }

    public EntidadFederativa getEntidad() {
        return entidad;
    }

    public void setEntidad(EntidadFederativa entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EntidadFederativaDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
