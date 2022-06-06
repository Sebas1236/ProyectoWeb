/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Usuario;

/**
 *
 * @author Sebastián
 */
public class UsuarioDTO implements Serializable{
    private Usuario entidad;
    public UsuarioDTO()
    {
        this.entidad = new Usuario();
    }

    public Usuario getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuario entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsuarioDTO{entidad=").append(entidad);
        sb.append('}');
        return sb.toString();
    }
    
}
