package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class EspecieBuilder {

    private Integer id;
    private String nombre;

    public EspecieBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public EspecieBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Especie crearEspecie() {
        return Especie.crearEspecie(id, nombre);
    }

    public Especie crearEspecie(ResultSet rs) {

    	Especie especie = null;

        try {
        	especie = Especie.crearEspecie(rs.getInt("id"), rs.getString("nombre"));
        } catch (SQLException ex) {
            Logger.getLogger(EspecieBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especie;
    }

}
