package com.huatayc.springcloud.msvc.conductor.models.entity;

import jakarta.persistence.*;
;

@Entity
@Table(name = "conductores")
public class Conductor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombres;

        @Column(unique = true)
        private String dni;
        @Column(unique = true)
        private String brevete;
        private Boolean infraccionado;
        private Integer edad;
        private String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBrevete() {
        return brevete;
    }

    public void setBrevete(String brevete) {
        this.brevete = brevete;
    }

    public Boolean getInfraccionado() {
        return infraccionado;
    }

    public void setInfraccionado(Boolean infraccionado) {
        this.infraccionado = infraccionado;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
