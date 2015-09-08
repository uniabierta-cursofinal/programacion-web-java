package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    	Doctor doctor = null;

		try {

			 doctor = Doctor.crearDoctor(rs.getInt("id"), rs.getString("doctor"), rs.getString("apellido") );

		} catch (SQLException ex) {
			 Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}

        return doctor;
    }
}
