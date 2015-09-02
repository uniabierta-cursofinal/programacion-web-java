package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.util.Date;

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
    private Date fecha_nacimiento;
    private Integer peso;

    private Paciente(Integer id, Cliente cliente, String nombre, String genero, Raza raza, Date fecha_nacimiento, Integer peso) {
        this.id = id;
        this.cliente = cliente;
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.fecha_nacimiento = fecha_nacimiento;
        this.peso = peso;
    }
    
    static Paciente crearPaciente(Integer id, Cliente cliente, String nombre, String genero, Raza raza, Date fecha_nacimiento, Integer peso){
        return new Paciente(id, cliente, nombre, genero, raza, fecha_nacimiento, peso);
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

}
