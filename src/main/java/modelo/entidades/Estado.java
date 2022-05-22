/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.io.Serializable;



/**
 *
 * @author darkdestiny 
 */
public class Estado implements Serializable{

    private int idEstado; 
    private String nombreEstado;
    
    public Estado(){
    }
    
    public void setIdEstado(int idEstado){
        this.idEstado = idEstado;
    }
    
    public int getIdEstado(){
        return idEstado;
    }
    
    public void setNombreEstado(String nombreEstado){
        this.nombreEstado = nombreEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }
    
    
}
