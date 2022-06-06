/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.TipoContacto;

/**
 *
 * @author Sebastián
 */
public class TipoContactoDTO implements Serializable{
    private TipoContacto entidad;
    public TipoContactoDTO()
    {
        this.entidad = new TipoContacto();
    }

    public TipoContacto getEntidad() {
        return entidad;
    }

    public void setEntidad(TipoContacto entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipoContactoDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
