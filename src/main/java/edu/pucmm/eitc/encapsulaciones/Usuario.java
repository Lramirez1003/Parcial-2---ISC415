package edu.pucmm.eitc.encapsulaciones;


import jakarta.persistence.*;
import java.io.Serializable;
import edu.pucmm.eitc.util.RolesApp;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity

public class Usuario implements Serializable {
    @Id
    private String usuario;
    private String password;
    Set<RolesApp>  listaRoles;
    //@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER) // La clase "Clase" es la dueña de la relación.
   // private Set<Formulario> misEnlaces = new HashSet<Formulario>();

    public Usuario() {

    }

    public Usuario(String usuario, String password, Set<RolesApp> listaRoles) {
        this.usuario = usuario;
        this.password = password;
        this.listaRoles = listaRoles;
    }

    public Usuario(String user, String pass) {
        this.usuario = user;
        this.password = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

/*
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RolesApp> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(Set<RolesApp> ListaRoles) {
        this.listaRoles = ListaRoles;
    }

//    public Set<Enlace> getMisEnlaces() {
//        return misEnlaces;
//    }
//
//    public void setMisEnlaces(Set<Enlace> misEnlaces) {
//        this.misEnlaces = misEnlaces;
//    }


}