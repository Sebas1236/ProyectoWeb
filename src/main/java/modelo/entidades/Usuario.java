
package modelo.entidades;

import java.io.Serializable;


public class Usuario implements Serializable{
    private int idUsu;
    private String nombreUsu;
    private String passwordUsu;
    private String correoUsu;
    private String role;
    public Usuario(){}
    public Usuario(int idUsu, String nombreUsu, String correoUsu, String role)
    {
        this.idUsu = idUsu;
        this.nombreUsu = nombreUsu;
        this.correoUsu = correoUsu;
        this.role = role;
    }
    public String getCorreoUsu() {
        return correoUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }
    

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getPasswordUsu() {
        return passwordUsu;
    }

    public void setPasswordUsu(String passwordUsu) {
        this.passwordUsu = passwordUsu;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
