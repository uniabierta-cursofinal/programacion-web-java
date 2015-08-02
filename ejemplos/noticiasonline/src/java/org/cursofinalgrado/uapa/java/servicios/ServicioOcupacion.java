/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.uapa.java.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cursofinalgrado.uapa.java.entidades.Ocupacion;
import org.cursofinalgrado.uapa.java.entidades.Pais;

/**
 *
 * @author ecabrerar
 */
public class ServicioOcupacion {

    private final static ServicioOcupacion INSTANCIA = new ServicioOcupacion();

    private ServicioOcupacion() {
    }

    public static ServicioOcupacion getInstancia() {
        return INSTANCIA;
    }

    public List<Ocupacion> getOcupaciones() {

        List<Ocupacion> lista = new ArrayList<>();

        String sql = "select * from ocupaciones";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        Ocupacion ocupacion = new Ocupacion();
                        ocupacion.setId(rs.getInt("codigo_ocupacion"));
                        ocupacion.setDescripcion(rs.getString("descripcion"));

                        lista.add(ocupacion);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicioOcupacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
