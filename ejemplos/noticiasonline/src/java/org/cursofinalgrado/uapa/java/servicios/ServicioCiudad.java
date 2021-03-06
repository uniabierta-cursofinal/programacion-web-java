/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.uapa.java.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cursofinalgrado.uapa.java.entidades.Ciudad;

/**
 *
 * @author ecabrerar
 */
public class ServicioCiudad {

    private static final ServicioCiudad INSTANCIA = new ServicioCiudad();

    public static ServicioCiudad getInstancia() {
        return INSTANCIA;
    }

    private ServicioCiudad() {
    }

    public List<Ciudad> getListadoCiudades() {

        List<Ciudad> lista = new ArrayList<>();

        String sql = "select * from ciudades";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (Statement stmt = con.createStatement()) {

                try (ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {

                        Ciudad ciudad = new Ciudad();
                        ciudad.setId(rs.getInt("codigo_ciudad"));
                        ciudad.setNombre(rs.getString("nombre"));
                        ciudad.setPais(ServicioPais.getInstancia().getPaisPorId(rs.getInt("codigo_pais")));

                        lista.add(ciudad);
                    }
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(ServicioCiudad.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista;
    }

    public boolean crearCiudad(Ciudad ciudad) {

        boolean estado;

        String sql = "insert into ciudades(nombre,codigo_pais) values(?,?)";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setString(1, ciudad.getNombre());
                stmt.setInt(2, ciudad.getPais().getId());

                stmt.executeUpdate();

                estado = true;
            }

        } catch (SQLException e) {
            estado = false;
            Logger.getLogger(ServicioCiudad.class.getName()).log(Level.SEVERE, null, e);
        }

        return estado;

    }
}
