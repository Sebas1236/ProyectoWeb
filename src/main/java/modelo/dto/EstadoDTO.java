/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import modelo.entidades.Estado;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class EstadoDTO implements Serializable{
    private Estado entidad;

    public EstadoDTO() {
        entidad = new Estado();
    }

    public Estado getEntidad() {
        return entidad;
    }

    public void setEntidad(Estado entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Estado : ").append(getEntidad().getIdEstado()).append("\n");
        sb.append("Nombre Estado : ").append(getEntidad().getNombreEstado()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        EstadoDTO dto = new EstadoDTO();
        dto.getEntidad().setIdEstado(1);
        dto.getEntidad().setNombreEstado("México");
        
        System.out.println(dto);
    }
    
    
}
