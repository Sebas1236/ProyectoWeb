/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Empresa;

/**
 *
 * @author Sebastián
 */
public class EmpresaDTO implements Serializable{
    private Empresa entidad;
    public EmpresaDTO()
    {
        this.entidad = new Empresa();
    }

    public Empresa getEntidad() {
        return entidad;
    }

    public void setEntidad(Empresa entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmpresaDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
