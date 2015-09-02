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
public class PaisBuilder {

    private Integer id;
    private String descripcion;

    public PaisBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaisBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Pais crearPais() {
        return Pais.crearPais(id, descripcion);
    }

    public Pais crearPais(ResultSet rs) {
        Pais pais = null;

        try {
            pais = Pais.crearPais(rs.getInt("id"), rs.getString("descripcion"));
        } catch (SQLException ex) {
            Logger.getLogger(PaisBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pais;
    }

}
