/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Actitudes;

/**
 *
 * @author Sebastián
 */
public class ActitudesDTO implements Serializable{
    private Actitudes entidad;
    public ActitudesDTO()
    {
        this.entidad = new Actitudes();
    }
    public Actitudes getEntidad() {
        return entidad;
    }

    public void setEntidad(Actitudes entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActitudesDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
    
}
