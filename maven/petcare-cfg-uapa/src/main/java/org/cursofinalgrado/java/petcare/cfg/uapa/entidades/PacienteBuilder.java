package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.time.LocalDate;

/**
 *
 * @author ecabrerar
 */
public class PacienteBuilder {

    private Integer id;
    private Cliente cliente;
    private String nombre;
    private String genero;
    private Raza raza;
    private LocalDate fechaNacimiento;
    private Integer peso;

    public PacienteBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PacienteBuilder setCliente(Cliente cliente) {
        this.cliente = cliente;
         return this;
    }

    public PacienteBuilder setNombre(String nombre) {
        this.nombre = nombre;
         return this;
    }

    public PacienteBuilder setGenero(String genero) {
        this.genero = genero;
         return this;
    }

    public PacienteBuilder setRaza(Raza raza) {
        this.raza = raza;
         return this;
    }

    public PacienteBuilder setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
         return this;
    }

    public PacienteBuilder setPeso(Integer peso) {
        this.peso = peso;
         return this;
    }

    public Paciente crearPaciente(){
        return Paciente.crearPaciente(id, cliente, nombre, genero, raza, fechaNacimiento, peso);
    }



}
