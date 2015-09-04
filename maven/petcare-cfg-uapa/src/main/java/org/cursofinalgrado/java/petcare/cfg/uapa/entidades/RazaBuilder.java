/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class RazaBuilder {
    private Integer id;
    private String nombre;
    private Especie especie;

    /**
     * @param id the id to set
     * @return 
     */
    public RazaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * @param nombre the nombre to set
     * @return 
     */
    public RazaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @param especie the especie to set
     * @return 
     */
    public RazaBuilder setEspecie(Especie especie) {
        this.especie = especie;
        return this;
    }
    
    public Raza crearRaza(){
        return Raza.crearRaza(id, nombre, especie);
    }
    
     public Raza crearRaza(ResultSet rs){
         
        Raza raza = null;
        
        try {
            raza = Raza.crearRaza(rs.getInt("id"), rs.getString("nombre"), especie);
        } catch (SQLException ex) {
            Logger.getLogger(RazaBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return raza;
    }     
    
}