package edu.pucmm.eitc.encapsulaciones;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Formulario implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String sector;

    private String nivel_escolar;
    private String usuario_reg;


    public Formulario(String nombre, String sector, String nivel_escolar,String usuario_reg) {
        this.nombre = nombre;
        this.sector = sector;
        this.nivel_escolar = nivel_escolar;
        this.usuario_reg = usuario_reg;

    }

    public Formulario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNivel_escolar() {
        return nivel_escolar;
    }

    public void setNivel_escolar(String nivel_escolar) {
        this.nivel_escolar = nivel_escolar;
    }

    public String getUsuario_reg() {
        return usuario_reg;
    }

    public void setUsuario_reg(String usuario_reg) {
        this.usuario_reg = usuario_reg;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
