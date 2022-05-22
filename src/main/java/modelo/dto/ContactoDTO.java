/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Contacto;

/**
 *
 * @author Sebastián
 */
public class ContactoDTO implements Serializable{
    private Contacto entidad;
    public ContactoDTO()
    {
        this.entidad = new Contacto();
    }

    public Contacto getEntidad() {
        return entidad;
    }

    public void setEntidad(Contacto entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactoDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
