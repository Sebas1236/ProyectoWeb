/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Aptitudes;

/**
 *
 * @author Sebastián
 */
public class AptitudesDTO implements Serializable{
    private Aptitudes entidad;
    public AptitudesDTO()
    {
        this.entidad = new Aptitudes();
    }

    public Aptitudes getEntidad() {
        return entidad;
    }

    public void setEntidad(Aptitudes entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AptitudesDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
