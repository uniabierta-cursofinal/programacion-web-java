package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.time.LocalDate;

/**
 *
 * @author ecabrerar
 */
public class Paciente {

    private Integer id;
    private Cliente cliente;
    private String nombre;
    private String genero;
    private Raza raza;
    private LocalDate fechaNacimiento;
    private Integer peso;

    private Paciente(Integer id, Cliente cliente, String nombre, String genero, Raza raza, LocalDate fechaNacimiento, Integer peso) {
        this.id = id;
        this.cliente = cliente;
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }
    
    static Paciente crearPaciente(Integer id, Cliente cliente, String nombre, String genero, Raza raza, LocalDate fechaNacimiento, Integer peso){
        return new Paciente(id, cliente, nombre, genero, raza, fechaNacimiento, peso);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

}
