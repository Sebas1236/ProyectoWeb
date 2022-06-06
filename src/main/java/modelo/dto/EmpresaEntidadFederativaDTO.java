/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.EmpresaEntidadFederativa;

/**
 *
 * @author Sebastián
 */
public class EmpresaEntidadFederativaDTO implements Serializable{
    private EmpresaEntidadFederativa entidad;
    public EmpresaEntidadFederativaDTO()
    {
        this.entidad = new EmpresaEntidadFederativa();
    }

    public EmpresaEntidadFederativa getEntidad() {
        return entidad;
    }

    public void setEntidad(EmpresaEntidadFederativa entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmpresaEntidadFederativaDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }


    
}
