/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;

/**
 *
 * @author ecabrerar
 */
public class DoctorBuilder {

    private Integer id;
    private String nombre;
    private String apellido;

    public DoctorBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public DoctorBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DoctorBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Doctor crearDoctor() {
        return Doctor.crearDoctor(id, nombre, apellido);
    }

    public Doctor crearDoctor(ResultSet rs) {
        return Doctor.crearDoctor(id, nombre, apellido);
    }
}
