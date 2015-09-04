/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author ecabrerar
 */
public class CitaBuilder {

    private Integer id;
    private Date fecha;
    private Paciente paciente;
    private Doctor doctor;
    private String razon;

    public CitaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public CitaBuilder setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public CitaBuilder setPaciente(Paciente paciente) {
        this.paciente = paciente;
        return this;
    }

    public CitaBuilder setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public CitaBuilder setRazon(String razon) {
        this.razon = razon;
        return this;
    }

    public Cita crearCita() {
        return Cita.crearCita(id, fecha, paciente, doctor, razon);
    }

    public Cita crearCita(ResultSet rs) {
        return Cita.crearCita(id, fecha, paciente, doctor, razon);
    }


}
