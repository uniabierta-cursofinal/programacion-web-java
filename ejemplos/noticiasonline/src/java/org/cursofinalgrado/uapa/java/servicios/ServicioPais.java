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
import org.cursofinalgrado.uapa.java.entidades.Pais;

/**
 *
 * @author ecabrerar
 */
public class ServicioPais {

    private static final ServicioPais INSTANCIA = new ServicioPais();

    private ServicioPais() {
    }

    public static ServicioPais getInstancia() {
        return INSTANCIA;
    }

    public List<Pais> getListadoPais() {

        List<Pais> lista = new ArrayList<>();

        String sql = "select * from pais";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        Pais pais = new Pais();
                        pais.setId(rs.getInt("codigo_pais"));
                        pais.setNombre(rs.getString("nombre"));

                        lista.add(pais);
                    }
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista;
    }

    public Pais getPaisPorId(int id) {

        String sql = "select * from pais where codigo_pais=?";

        Pais pais = null;

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {

                    rs.next();
                    pais = new Pais();
                    pais.setId(rs.getInt("codigo_pais"));
                    pais.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
        }

        return pais;
    }
}
