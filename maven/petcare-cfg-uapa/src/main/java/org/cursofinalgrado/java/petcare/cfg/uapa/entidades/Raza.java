/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

/**
 *
 * @author ecabrerar
 */
public class Raza {
    private Integer id;
    private String nombre;
    private Especie especie;

    private Raza(Integer id, String nombre, Especie especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
    }
    
    
    static Raza crearRaza(Integer id, String nombre, Especie especie){
        return new Raza(id, nombre, especie);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the especie
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    
    
}
